package com.raghuveer.BookMyShow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghuveer.BookMyShow.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);

}

