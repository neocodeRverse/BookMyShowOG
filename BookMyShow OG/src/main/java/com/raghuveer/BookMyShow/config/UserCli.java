package com.raghuveer.BookMyShow.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.raghuveer.BookMyShow.entity.User;
import com.raghuveer.BookMyShow.enumerated.Role;
import com.raghuveer.BookMyShow.repository.UserRepository;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserCli implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() > 0) return;

        var admin = User.builder()
                        .name("Admin")
                        .userId("admin")
                        .password(passwordEncoder.encode("Admin@123"))
                        .role(Role.ADMIN)
                        .build();
        userRepository.save(admin);
    }

    
}

