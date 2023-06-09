package com.example.telematika_homework.repository;

import com.example.telematika_homework.model.SerialSecret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerialSecretRepositary extends JpaRepository<SerialSecret, String> {
}
