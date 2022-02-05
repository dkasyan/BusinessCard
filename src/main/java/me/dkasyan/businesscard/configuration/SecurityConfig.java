package me.dkasyan.businesscard.configuration;

import lombok.RequiredArgsConstructor;
import me.dkasyan.businesscard.configuration.security.CustomAuthenticationFilter;
import me.dkasyan.businesscard.configuration.security.UserSkeleton;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserSkeleton userSkeleton;

    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {
        var customFilter = new CustomAuthenticationFilter(authenticationManager(), userSkeleton);

        http.csrf().disable()
            .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers("/login*").permitAll()
            .anyRequest().authenticated().and()
//            .formLogin()
//            .and()
        ;
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
