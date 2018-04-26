package com.makh.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created on 15.04.2018.
 */
public class Doctor extends Human implements Serializable {
    private String speciality;
    private Schedule schedule;

    public Doctor(String name, String surname, String speciality,
                  LocalTime startWork, LocalTime finishWork, int numberOfCabinet) {
        super(name, surname);
        this.schedule = new Schedule(startWork, finishWork, numberOfCabinet);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String addAppointment(Patient patient) {
        Appointment appointment = schedule.addAppointment(patient);
        String temp = "Ви записалися на прийом:\n" + appointment.toString() + "Лікар:\n" + this.toString();
        return temp;
    }

    @Override
    public String toString() {
        return "Id лікаря - " + getId() +
                "\nПІБ - " + getName() + " " + getSurname() +
                "\nСпеціальність - " + speciality + "\n" +
                schedule.toString();
    }
}
