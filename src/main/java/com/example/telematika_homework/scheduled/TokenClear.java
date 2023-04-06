package com.example.telematika_homework.scheduled;

import com.example.telematika_homework.repository.TokenRepositary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenClear {
    private final TokenRepositary tokenRepositary;

    public TokenClear(TokenRepositary tokenRepositary) {
        this.tokenRepositary = tokenRepositary;
    }

    @Scheduled(fixedDelay = 1000)
    public void clearTokens() {
        tokenRepositary.deleteAllByExpiredDateIsBefore(Instant.now());
    }
}
