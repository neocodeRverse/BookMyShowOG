package com.raghuveer.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.raghuveer.BookMyShow.entity.owner;

@Repository
public interface OwnerRepo extends JpaRepository<owner, Long>{
    
}
