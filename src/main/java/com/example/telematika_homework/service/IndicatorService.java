package com.example.telematika_homework.service;

import com.example.telematika_homework.dto.LogIndicator;
import com.example.telematika_homework.model.Indicator;
import com.example.telematika_homework.model.SerialSecret;
import com.example.telematika_homework.repository.IndicatorRepository;
import org.springframework.stereotype.Service;

@Service
public class IndicatorService {
    private IndicatorRepository indicatorRepository;

    public IndicatorService(IndicatorRepository indicatorRepository) {
        this.indicatorRepository = indicatorRepository;
    }

    public Double calculateAVGIndicator(String serial) {
        return indicatorRepository.getAVGIndicator(serial);
    }

    public void save(SerialSecret serialSecret, LogIndicator logIndicator) {
        Indicator indicator = new Indicator();
        indicator.setValue(indicator.getValue());
        indicator.setSerialSecret(serialSecret);
        indicatorRepository.save(indicator);
    }
}
