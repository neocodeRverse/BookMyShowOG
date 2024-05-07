package com.raghuveer.BookMyShow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghuveer.BookMyShow.dto.request.RegisterRequest;
import com.raghuveer.BookMyShow.dto.response.BasicResponse;
import com.raghuveer.BookMyShow.entity.customer;
import com.raghuveer.BookMyShow.enumerated.Role;
import com.raghuveer.BookMyShow.service.AdminService;
import com.raghuveer.BookMyShow.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/bms/customer/service")
public class customerController {
    
    @Autowired
    CustomerService customerService;

    private final AdminService adminService;

    @PostMapping("/register")
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

    @PostMapping
    public customer saveCustomer(@RequestBody customer customers){
        return customerService.save(customers);
    }
 
    @GetMapping
    public Iterable<customer> getAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<customer> getCustomerById(@PathVariable("id") Long id){
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public customer updateCustomer(@PathVariable("id") Long id, @RequestBody customer customers){
        customers.setId(id);
        return customerService.save(customers);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer (@PathVariable("id") Long id){
        customerService.deleteById(id);
    }
}
