package com.raghuveer.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghuveer.BookMyShow.entity.customer;

@Repository
public interface CustomerRepo extends JpaRepository<customer, Long>{
    
}
