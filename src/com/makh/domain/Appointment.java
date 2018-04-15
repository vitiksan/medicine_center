package com.makh.domain;

import java.time.LocalDateTime;

/**
 * Created on 15.04.2018.
 */
public class Appointment {
    private LocalDateTime time;
    private Patient patient;

    public Appointment(LocalDateTime time, Patient patient) {;
        this.time = time;
        this.patient = patient;
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

    @Override
    public String toString() {
        return "Час запису - " + time.toString() +
                "\nПацієнт:\n" + patient.toString();
    }
}
