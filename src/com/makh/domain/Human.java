package com.makh.domain;

import java.io.Serializable;

public abstract class Human implements Serializable {
    private static int _id = 0;
    private int id;
    private String name;
    private String surname;

    public Human(String name, String surname) {
        setId();
        this.name = name;
        this.surname = surname;
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
}
