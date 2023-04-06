package com.example.telematika_homework.scheduled;

import com.example.telematika_homework.repository.TokenRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenClear {
    private final TokenRepository tokenRepositary;

    public TokenClear(TokenRepository tokenRepositary) {
        this.tokenRepositary = tokenRepositary;
    }

    @Scheduled(fixedDelay = 1000)
    public void clearTokens() {
        tokenRepositary.deleteAllByExpiredDateIsBefore(Instant.now());
    }
}
