package com.raghuveer.BookMyShow.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghuveer.BookMyShow.dto.request.RegisterRequest;
import com.raghuveer.BookMyShow.dto.response.BasicResponse;
import com.raghuveer.BookMyShow.entity.User;
import com.raghuveer.BookMyShow.enumerated.Role;
import com.raghuveer.BookMyShow.service.AdminService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/bms/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/register/customer")
    public ResponseEntity<BasicResponse<String>> registerCustomer(@Valid @RequestBody RegisterRequest registerRequest) {
        BasicResponse<String> response = new BasicResponse<>();
        try {
            response = adminService.register(registerRequest, Role.CUSTOMER);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Something went wrong");
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/register/owner")
    public ResponseEntity<BasicResponse<String>> registerTeacher(@Valid @RequestBody RegisterRequest registerRequest) {
        BasicResponse<String> response = new BasicResponse<>();
        try {
            response = adminService.register(registerRequest, Role.TOWNER);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Something went wrong");
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/getAll/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(adminService.findAll(), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}

