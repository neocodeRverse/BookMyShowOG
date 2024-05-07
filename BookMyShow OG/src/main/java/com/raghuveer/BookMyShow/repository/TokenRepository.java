package com.raghuveer.BookMyShow.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghuveer.BookMyShow.entity.Token;



@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);

    List<Token> findAllByUser_IdAndRevokedFalseAndExpiredFalse(long id);

}
