package com.example.telematika_homework.repository;

import com.example.telematika_homework.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface TokenRepositary extends JpaRepository<Token, Long> {
    void deleteAllByExpiredDateIsBefore(Instant now);

    Optional<Token> findById(String uuid);
}
