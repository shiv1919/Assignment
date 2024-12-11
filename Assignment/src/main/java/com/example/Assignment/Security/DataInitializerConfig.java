package com.example.Assignment.Security;

import com.example.Assignment.entity.User;
import com.example.Assignment.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializerConfig {

    @Bean
    public CommandLineRunner initializeUsers(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("adminpass"));
            adminUser.setRole(User.UserRole.ADMIN);
            userRepository.save(adminUser);

            User studentUser = new User();
            studentUser.setUsername("student");
            studentUser.setPassword(passwordEncoder.encode("studentpass"));
            studentUser.setRole(User.UserRole.STUDENT);
            userRepository.save(studentUser);
        };
    }
}
