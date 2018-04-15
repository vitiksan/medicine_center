package com.makh.domain;

import java.time.LocalDateTime;

/**
 * Created on 15.04.2018.
 */
public class Appointment {
    private static int _id = 0;
    private int id;
    private LocalDateTime time;
    private Patient patient;

    public Appointment(LocalDateTime time, Patient patient) {
        setId();
        this.time = time;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        this.id = ++_id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
