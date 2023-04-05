package com.example.telematika_homework.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long value;
    private Instant createDate = Instant.now();
    @ManyToOne
    private SerialSecret serialSecret;

    public Indicator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public SerialSecret getSerialSecret() {
        return serialSecret;
    }

    public void setSerialSecret(SerialSecret serialSecret) {
        this.serialSecret = serialSecret;
    }
}
