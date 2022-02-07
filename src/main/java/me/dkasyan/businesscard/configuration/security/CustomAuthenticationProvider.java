package me.dkasyan.businesscard.configuration.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserSkeleton userSkeleton;

    @Override
    public Authentication authenticate(@NotNull Authentication authentication) throws AuthenticationException {
        return Optional.ofNullable(authentication.getCredentials())
                       .map(Object::toString)
                       .filter(password -> password.equals(userSkeleton.getPassword()))
                       .map(credentials -> {
                           var result = new UsernamePasswordAuthenticationToken(userSkeleton,
                                   authentication.getCredentials(), Collections.emptyList());
                           result.setDetails(authentication.getDetails());
                           log.info("Authenticated user");
                           return result;
                       })
                       .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));
    }

    @Override
    public boolean supports(@NotNull Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
