package com.example.telematika_homework.repository;

import com.example.telematika_homework.model.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorRepository extends JpaRepository<Indicator, Long> {
    @Query(value = "SELECT AVG(i.value) FROM Indicator i WHERE i.serialSecret.serial=?1")
    Double getAVGIndicator(String serial);
}
