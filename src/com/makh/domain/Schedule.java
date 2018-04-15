package com.makh.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule implements Serializable {
    private LocalTime startWork;
    private LocalTime finishWork;
    private int numberOfCabinet;
    private ArrayList<Appointment> appointments;

    public Schedule(LocalTime startWork, LocalTime finishWork, int numberOfCabinet) {
        this.startWork = startWork;
        this.finishWork = finishWork;
        this.numberOfCabinet = numberOfCabinet;
        this.appointments = new ArrayList<>();
    }

    public void setStartWork(LocalTime startWork) {
        this.startWork = startWork;
    }

    public void setFinishWork(LocalTime finishWork) {
        this.finishWork = finishWork;
    }

    public void setNumberOfCabinet(int numberOfCabinet) {
        this.numberOfCabinet = numberOfCabinet;
    }

    public LocalTime getStartWork() {
        return startWork;
    }

    public LocalTime getFinishWork() {
        return finishWork;
    }

    public int getNumberOfCabinet() {
        return numberOfCabinet;
    }

    public ArrayList<Appointment> getAppointments() {
        clearCompletedAppointments();
        return appointments;
    }

    public Appointment addAppointment(Patient patient) {
        clearCompletedAppointments();
        if (appointments.size() != 0) {
            LocalDateTime last = appointments.get(appointments.size() - 1).getTime();
            last = last.plusMinutes(15);
            if (last.toLocalTime().plusMinutes(15).isBefore(finishWork)) {
                Appointment newApp = new Appointment(last, patient);
                appointments.add(newApp);
                return newApp;
            } else {
                LocalDate temp = (last.getDayOfWeek().getValue() == 5) ? last.toLocalDate().plusDays(3) : last.toLocalDate().plusDays(1);
                Appointment newApp = new Appointment(LocalDateTime.of(temp, startWork), patient);
                appointments.add(newApp);
                return newApp;
            }
        } else {
            LocalDate temp;
            if (LocalDate.now().getDayOfWeek().getValue() == 5) {
                temp = LocalDate.now().plusDays(3);
            } else if (LocalDate.now().getDayOfWeek().getValue() == 6) {
                temp = LocalDate.now().plusDays(2);
            } else temp = LocalDate.now().plusDays(1);
            Appointment newApp = new Appointment(LocalDateTime.of(temp, startWork), patient);
            appointments.add(newApp);
            return newApp;
        }
    }

    private void clearCompletedAppointments() {
        for (Appointment each : appointments) {
            if (each.getTime().plusMinutes(15).isBefore(LocalDateTime.now())) {
                appointments.remove(each);
            }
        }
    }

    @Override
    public String toString() {
        return "Графік роботи по буднях" +
                "\nз " + startWork.toString() +
                " до " + finishWork.toString() +
                "\nКабінет - " + numberOfCabinet + "\n";
    }
}
