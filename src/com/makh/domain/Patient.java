package com.makh.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created on 15.04.2018.
 */
public class Patient extends Human implements Serializable {
    private LocalDate birthday;
    private String placeOfResidence;

    public Patient(String name, String surname, LocalDate birthday, String placeOfResidence) {
        super(name, surname);
        this.birthday = birthday;
        this.placeOfResidence = placeOfResidence;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    @Override
    public String toString() {
        return "Id пацієнта - " + getId() +
                "\nПІБ - " + getName() + " " + getSurname() +
                "\nДата народження - " + birthday.toString() +
                "\nМісце проживання - " + placeOfResidence + "\n";
    }
}