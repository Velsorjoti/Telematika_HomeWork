package com.example.telematika_homework.controller;

import com.example.telematika_homework.dto.LogIndicator;
import com.example.telematika_homework.model.SerialSecret;
import com.example.telematika_homework.model.Token;
import com.example.telematika_homework.service.IndicatorService;
import com.example.telematika_homework.service.SerialSecretService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/indicators")
public class IndicationController {
    private final IndicatorService indicatorService;
    private final SerialSecretService serialSecretService;

    public IndicationController(IndicatorService indicatorService, SerialSecretService serialSecretService) {
        this.indicatorService = indicatorService;
        this.serialSecretService = serialSecretService;
    }

    @PostMapping
    public void sign(@RequestBody LogIndicator logIndicator, Authentication authentication) {
        Token principal= (Token) authentication.getPrincipal();
        indicatorService.save(principal.getSerialSecret(), logIndicator);
    }
    @GetMapping
    public double avg(@PathVariable String serial){
        return indicatorService.calculateAVGIndicator(serial);
    }

    @PostMapping("/login")
    public Token createLogin(@RequestBody SerialSecret serialSecret) {
        return serialSecretService.newToken(serialSecret.getSerial(), serialSecret.getSecret());
    }
}

