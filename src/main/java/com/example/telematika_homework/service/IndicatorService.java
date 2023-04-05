package com.example.telematika_homework.service;

import com.example.telematika_homework.repository.IndicatorRepository;
import org.springframework.stereotype.Service;

@Service
public class IndicatorService {
    private IndicatorRepository indicatorRepo;

    public IndicatorService(IndicatorRepository indicatorRepo) {
        this.indicatorRepo = indicatorRepo;
    }

}
