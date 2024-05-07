package com.raghuveer.BookMyShow.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raghuveer.BookMyShow.dto.request.RegisterRequest;
import com.raghuveer.BookMyShow.dto.response.BasicResponse;
import com.raghuveer.BookMyShow.entity.User;
import com.raghuveer.BookMyShow.enumerated.Role;
import com.raghuveer.BookMyShow.repository.UserRepository;
import com.raghuveer.BookMyShow.service.AdminService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public BasicResponse<String> register(RegisterRequest registerRequest, Role role) throws Exception {
        Optional<User> userOps = userRepository.findByUserId(registerRequest.getUserId());
        if(userOps.isPresent()) throw new Exception(registerRequest.getUserId() + " Already Exists");
        var user = User.builder()
                    .name(registerRequest.getName())
                    .userId(registerRequest.getUserId())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .role(role)
                    .build();

        userRepository.save(user);

        return BasicResponse.<String>builder().message("User Registered successfully").data("").build();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().toList();
    }

}
