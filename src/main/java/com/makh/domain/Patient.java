package com.makh.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created on 15.04.2018.
 */
public class Patient extends Human implements Serializable {
    private LocalDate birthday;
    private String address;

    public Patient(String name, String surname, LocalDate birthday, String address) {
        super(name, surname);
        this.birthday = birthday;
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Id пацієнта - " + getId() +
                "\nПІБ - " + getName() + " " + getSurname() +
                "\nДата народження - " + birthday.toString() +
                "\nМісце проживання - " + address + "\n";
    }
}