package me.dkasyan.businesscard.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dkasyan.businesscard.configuration.security.CustomAuthenticationProvider;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {

        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/login*", "/css/**", "/fonts/**", "/images/**", "/js/**", "/scss/**").permitAll()
            .anyRequest().authenticated().and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=true").failureHandler((request, response, exception) -> {
                log.error("Authentication failed!");
                response.sendRedirect("/login?error=true");
            })
            .defaultSuccessUrl("/", true);

    }

    @Override
    protected void configure(final @NotNull AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }
}
