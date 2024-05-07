package com.raghuveer.BookMyShow.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.raghuveer.BookMyShow.entity.customer;
import com.raghuveer.BookMyShow.repository.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    
    
    private final CustomerRepo customerRepo;

    public customer save(customer customer){
        return customerRepo.save(customer);
    }
    
    public Optional<customer> findById(final Long aLong){
        return customerRepo.findById(aLong);
    }

    public Iterable<customer> findAll(){
        return customerRepo.findAll();
    }

    public void deleteById(final Long aLong){
        customerRepo.deleteById(aLong);
    }
}
