package com.raghuveer.BookMyShow.controller;

import org.springframework.web.bind.annotation.RestController;

import com.raghuveer.BookMyShow.dto.request.LoginRequest;
import com.raghuveer.BookMyShow.dto.response.BasicResponse;
import com.raghuveer.BookMyShow.dto.response.LoginResponse;
import com.raghuveer.BookMyShow.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/bms/login")
    public ResponseEntity<BasicResponse<LoginResponse>> loginUser(@RequestBody LoginRequest loginRequest) {
        BasicResponse<LoginResponse> response = new BasicResponse<>();
        try {
            response = authenticationService.login(loginRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                BasicResponse.<LoginResponse>builder()
                            .message(e.getMessage())
                            .data(null)     
                            .build(),
                HttpStatus.EXPECTATION_FAILED);
        }
    }
}

