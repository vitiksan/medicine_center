package com.makh.domain;

import java.time.LocalDate;

/**
 * Created on 15.04.2018.
 */
public class Doctor extends Human {
    private String speciality;

    public Doctor(String name, String surname, LocalDate birthday, String speciality) {
        super(name, surname, birthday);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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
