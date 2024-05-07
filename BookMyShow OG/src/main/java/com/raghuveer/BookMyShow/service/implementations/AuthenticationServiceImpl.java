package com.raghuveer.BookMyShow.service.implementations;

import java.util.Map;
import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.raghuveer.BookMyShow.dto.request.LoginRequest;
import com.raghuveer.BookMyShow.dto.response.BasicResponse;
import com.raghuveer.BookMyShow.dto.response.LoginResponse;
import com.raghuveer.BookMyShow.entity.Token;
import com.raghuveer.BookMyShow.entity.User;
import com.raghuveer.BookMyShow.repository.TokenRepository;
import com.raghuveer.BookMyShow.repository.UserRepository;
import com.raghuveer.BookMyShow.service.AuthenticationService;
import com.raghuveer.BookMyShow.utils.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;
    @Override
    public BasicResponse<LoginResponse> login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword()));

        var userExists = userRepository.findByUserId(loginRequest.getUserId()).orElseThrow();
        Map<String, Object> claims = new HashMap<>();
        System.out.println("\n\n\n" + userExists.getRole().toString() + "\n\n\n");
        claims.put("role", userExists.getRole().toString());
        String accessToken = jwtUtil.generateToken(userExists, claims);
        revokeAllUserTokens(userExists);
        saveUserToken(accessToken, userExists);
        return BasicResponse.<LoginResponse>builder()
                .message("User logged in successfully")
                .data(
                        LoginResponse.builder().accessToken(accessToken)
                                .build())
                .build();
    }

    private void saveUserToken(String accessToken, User user) {
        var token = Token.builder()
                .token(accessToken)
                .user(user)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllByUser_IdAndRevokedFalseAndExpiredFalse(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

}

