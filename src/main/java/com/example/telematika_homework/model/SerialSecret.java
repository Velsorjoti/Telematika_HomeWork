package com.example.telematika_homework.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SerialSecret {
    @Id
    private String serial;
    private String secret;

    public SerialSecret() {
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
