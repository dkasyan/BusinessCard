package me.dkasyan.businesscard.configuration.security;

import lombok.extern.slf4j.Slf4j;
import me.dkasyan.businesscard.configuration.security.UserSkeleton;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserSkeleton userSkeleton;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, UserSkeleton userSkeleton) {
        super(authenticationManager);
        this.userSkeleton = userSkeleton;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("attempting authentication");
        var username = userSkeleton.getUsername();
        var password = obtainPassword(request);
        password = (password != null) ? password : "";
        var authRequest = new UsernamePasswordAuthenticationToken(username, password);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
