package com.example.telematika_homework.service;

import com.example.telematika_homework.model.SerialSecret;
import com.example.telematika_homework.model.Token;
import com.example.telematika_homework.repository.SerialSecretRepository;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class SerialSecretService {
    private final SerialSecretRepository serialSecretRepositary;

    private final Integer expiredSec;

    public SerialSecretService(SerialSecretRepository serialSecretRepositary, @Value("%{telematika.security.token-expired}") Integer expiredSec) {
        this.serialSecretRepositary = serialSecretRepositary;
        this.expiredSec = expiredSec;
    }

    public Token newToken(String serial, String secret) {
        SerialSecret serialSecret = serialSecretRepositary.findBySerial(serial);
        if(serialSecret != null && serialSecret.getSecret().equals(secret)){
            Token token = new Token();
            token.setUuid(UUID.randomUUID().toString());
            token.setExpiredDate(Instant.now().plus(expiredSec, ChronoUnit.SECONDS));
            token.setSerialSecret(serialSecret);
            return token;
        }
        return null;
    }
}
