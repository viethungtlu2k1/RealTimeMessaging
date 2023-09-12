package com.RealTimeMessaging;

import com.RealTimeMessaging.entity.Role;
import com.RealTimeMessaging.entity.User;
import com.RealTimeMessaging.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class RealTimeMessagingApplication {

    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("     Version 1 - 07/09/2023    ");
        System.out.println("===============================");
        SpringApplication.run(RealTimeMessagingApplication.class, args);
    }

//    @Bean
//    BCryptPasswordEncoder brBCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
//            userService.saveRole(new Role(null, "ROLE_USER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//            userService.saveUser(new User(null, "Viet Hung", "admin","admin@gmail.com","123456"));
//            userService.saveUser(new User(null, "Viet Hung", "viethung","viethung@gmail.com","123456"));
//
//            userService.addRoleToUser("admin", "ROLE_USER");
//            userService.addRoleToUser("admin", "ROLE_ADMIN");
//            userService.addRoleToUser("admin", "ROLE_SUPER_ADMIN");
//
//            userService.addRoleToUser("viethung", "ROLE_USER");
//        };
//    }

}
