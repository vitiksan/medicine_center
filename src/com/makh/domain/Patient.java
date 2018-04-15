package com.makh.domain;

import java.time.LocalDate;

/**
 * Created on 15.04.2018.
 */
public class Patient extends Human {
    private String placeOfResidence;

    public Patient(String name, String surname, LocalDate birthday, String placeOfResidence) {
        super(name, surname, birthday);
        this.placeOfResidence = placeOfResidence;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    @Override
    public String toString() {
        return "Id=" + getId() +
                "\nName= " + getName() +
                "\nSurname='" + getSurname() +
                "\nBirthday=" + getBirthday() +
                "\nPlace of residence=" + placeOfResidence + "\n";
    }
}