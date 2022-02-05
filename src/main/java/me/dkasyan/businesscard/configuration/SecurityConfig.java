package me.dkasyan.businesscard.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dkasyan.businesscard.configuration.security.CustomAuthenticationFilter;
import me.dkasyan.businesscard.configuration.security.UserSkeleton;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserSkeleton userSkeleton;

    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {
        var customFilter = new CustomAuthenticationFilter(authenticationManager(), userSkeleton);

        http.csrf().disable()
            .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers("/login*", "/css/**", "/fonts/**", "/images/**", "/js/**", "/scss/**").permitAll()
            .anyRequest().authenticated().and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=true").failureHandler(new AuthenticationFailureHandler() {
                @Override
                public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                    log.error("Authentication failed!");
                    response.sendRedirect("/login?error=true");
                }
            })
            .defaultSuccessUrl("/", false).permitAll().and();

    }

    @Override
    protected void configure(final @NotNull AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser(userSkeleton.getUsername()).password(passwordEncoder().encode(userSkeleton.getPassword())).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
