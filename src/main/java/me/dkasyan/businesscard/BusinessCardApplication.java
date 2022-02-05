package me.dkasyan.businesscard;

import me.dkasyan.businesscard.configuration.security.UserSkeleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BusinessCardApplication {

    @Bean
    UserSkeleton userSkeleton() {
        return new UserSkeleton("user1", "asdf");
    }

    public static void main(String[] args) {
        SpringApplication.run(BusinessCardApplication.class, args);
    }

}
