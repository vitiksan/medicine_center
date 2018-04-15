package com.makh.domain;

import java.time.LocalDate;

public abstract class Human {
    private static int _id = 0;
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;

    public Human(String name, String surname, LocalDate birthday) {
        setId();
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public static int get_id() {
        return _id;
    }

    public static void set_id(int _id) {
        Human._id = _id;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        this.id = ++_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
