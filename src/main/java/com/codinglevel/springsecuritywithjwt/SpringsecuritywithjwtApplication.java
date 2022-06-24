package com.codinglevel.springsecuritywithjwt;

import com.codinglevel.springsecuritywithjwt.entities.Role;
import com.codinglevel.springsecuritywithjwt.entities.User;
import com.codinglevel.springsecuritywithjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringsecuritywithjwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecuritywithjwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Hamdi ag", "Anara", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Mohamed ag", "Almousleck", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Mark ag", "Alba", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Aziz ag", "Toure", "password", new ArrayList<>()));

            userService.addRoleToUser("Anara", "ROLE_USER");
            userService.addRoleToUser("Almousleck", "ROLE_MANAGER");
            userService.addRoleToUser("Toure", "ROLE_USER");
            userService.addRoleToUser("Toure", "ROLE_ADMIN");
            userService.addRoleToUser("Toure", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("Alba", "ROLE_ADMIN");
        };
    }

}
