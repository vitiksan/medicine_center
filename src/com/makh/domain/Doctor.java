package com.makh.domain;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created on 15.04.2018.
 */
public class Doctor extends Human {
    private String speciality;
    private Schedule schedule;

    public Doctor(String name, String surname, LocalDate birthday, String speciality,
                  LocalTime startWork, LocalTime finishWork, int numberOfCabinet) {
        super(name, surname, birthday);
        this.schedule = new Schedule(startWork, finishWork, numberOfCabinet);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String addAppointment(Patient patient){
        return schedule.addAppointment(patient).toString();
    }

    @Override
    public String toString() {
        return "Id=" + getId() +
                "\nName= " + getName() +
                "\nSurname='" + getSurname() +
                "\nBirthday=" + getBirthday() +
                "\nSpeciality=" + speciality + "\n";
    }
}
