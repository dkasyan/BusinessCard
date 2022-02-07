package me.dkasyan.businesscard.configuration.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSkeleton {
    private String username;
    private String password;
}
