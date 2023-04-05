package com.example.telematika_homework.controller;

import com.example.telematika_homework.dto.LogIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/indicators")
public class IndicationController {

    @PostMapping
    public void sign(@RequestBody LogIndicator logIndicator) {

    }

    @GetMapping
    public double avg(){

    }
}
