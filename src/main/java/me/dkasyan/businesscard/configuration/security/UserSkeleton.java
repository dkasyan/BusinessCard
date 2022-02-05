package me.dkasyan.businesscard.configuration.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class UserSkeleton {
    private String username;
    private String password;

}
