package com.example.telematika_homework.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
public class Token {
    @Id
    private String uuid;
    private Instant expiredDate;
    @ManyToOne
    private SerialSecret serialSecret;

}
