package com.raghuveer.BookMyShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghuveer.BookMyShow.entity.owner;
import com.raghuveer.BookMyShow.repository.OwnerRepo;

@Service
public class ownerService {
    
    @Autowired
    OwnerRepo ownerRepo;

    public <S extends owner> S save(final S entity){
        return ownerRepo.save(entity);
    }

    // public Customer save(final Customer entity){
    //     return customerRepository.save(entity);
    // }
    
    public Optional<owner> findById(final Long aLong){
        return ownerRepo.findById(aLong);
    }

    public Iterable<owner> findAll(){
        return ownerRepo.findAll();
    }

    public void deleteById(final Long aLong){
        ownerRepo.deleteById(aLong);
    }
}
