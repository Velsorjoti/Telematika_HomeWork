package com.example.telematika_homework.service;

import com.example.telematika_homework.model.Token;
import com.example.telematika_homework.repository.TokenRepositary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AuthenticationService {
    private final TokenRepositary repositary;
    private final Integer expiredSec;

    public AuthenticationService(TokenRepositary repositary,@Value("%{telematika.security.token-expired}") Integer expiredSec) {
        this.repositary = repositary;
        this.expiredSec = expiredSec;
    }

    public Optional<Token> findbyUUID(String uuid) {
        Optional<Token> token = repositary.findById(uuid);
        if(token.isPresent() && Instant.now().isBefore(token.get().getExpiredDate())){
            return token;
        }
        return Optional.empty();
    }
}
