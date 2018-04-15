package com.makh;

import com.makh.domain.Appointment;
import com.makh.domain.Doctor;
import com.makh.domain.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 15.04.2018.
 */
public class Menu {
    private static ArrayList<Doctor> doctors;
    private static int choose = -1;
    private static Scanner in;

    static {
        in = new Scanner(System.in);
        doctors = Serializator.getData("db");
        if (doctors == null) doctors = new ArrayList<>();
    }

    public static void start() {
        do {
            information();
            choose = chooses();
            done(choose);
        } while (choose != 0);
    }

    private static void done(int temp) {
        switch (temp) {
            case 1:
                addDoctor();
                Serializator.saveData("db", doctors);
                start();
                break;
            case 2:
                printDoctors();
                break;
            case 3:
                addAppointment();
                Serializator.saveData("db", doctors);
                break;
            case 4:
                boolean found = false;
                printDoctors();
                do {
                    System.out.print("Введіть id лікаря щоб переглянути всі зааписи до нього - ");
                    int id = in.nextInt();
                    for (Doctor each : doctors) {
                        if (each.getId() == id) {
                            found = true;
                            if (each.getSchedule().getAppointments().isEmpty()) {
                                System.out.println("Наразі немає жодних записів до цього лікаря");
                                break;
                            }
                            for (Appointment item : each.getSchedule().getAppointments()) {
                                System.out.println("**********************\n" + item.toString() + "**********************");
                            }
                        }
                    }
                } while (!found);
                break;
            case 0:
                Serializator.saveData("db", doctors);
                System.exit(0);
                break;
            default:
                break;
        }

    }

    private static int chooses() {
        int temp = -1;
        do {
            try {
                System.out.print("Зробіть вибір: ");
                temp = in.nextInt();
                if (temp > 4) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Значення не введено або введено невірно");
                temp = -1;
            }
        } while (temp < 0);
        return temp;
    }

    private static void information() {
        System.out.println("Ви можете:");
        System.out.println("1-Додати нового лікаря");
        System.out.println("2-Вивести всіх лікарів");
        System.out.println("3-Зареєструватися на прийом до лікаря");
        System.out.println("4-Вивести всі записи до лікаря");
        System.out.println("0-Вийти");
    }

    private static void addDoctor() {
        boolean parseOk = true;
        System.out.print("Ім'я лікаря - ");
        String name = in.next();
        System.out.print("Прізвище лікаря - ");
        String surname = in.next();
        System.out.print("Спеціальність лікаря - ");
        String speciality = in.next();
        System.out.println("Введіть інформацію щодо розкладу роботи лікаря:");
        int numberOfCabinet = 0;
        do {
            parseOk = true;
            try {
                System.out.print("Номер кабінету де відбуватиметься прийом - ");
                numberOfCabinet = in.nextInt();
            } catch (Exception e) {
                in.nextLine();
                System.out.println("Хибно введено дані, спробуйте ще раз.");
                parseOk = false;
            }
        } while (!parseOk);
        LocalTime startWork = null;
        LocalTime finishWork = null;
        do {
            parseOk = true;
            try {
                System.out.print("Введіть час початку прийому у форматі \"14:35\" - ");
                startWork = LocalTime.parse(in.next());
                System.out.print("Введіть час завершення прийому у форматі \"14:35\" - ");
                finishWork = LocalTime.parse(in.next());
            } catch (Exception e) {
                in.nextLine();
                System.out.println("Помилка при введенні, спробуйте ще раз.");
                parseOk = false;
            }
        } while (!parseOk);
        doctors.add(new Doctor(name, surname, speciality, startWork, finishWork, numberOfCabinet));
    }

    private static void printDoctors() {
        for (Doctor each : doctors) {
            System.out.println("**********************\n" + each.toString() + "**********************");
        }
    }

    private static void addAppointment() {
        boolean found = false;
        printDoctors();
        do {
            System.out.print("Введіть id лікаря щоб записатися до нього на прийом - ");
            int id = in.nextInt();
            for (Doctor each : doctors) {
                if (each.getId() == id) {
                    found = true;
                    boolean parseOk = true;
                    System.out.print("Введіть детальну інформацію про себе:\n" +
                            "Ваше ім'я - ");
                    String name = in.next();
                    System.out.print("Ваше прізвище - ");
                    String surname = in.next();
                    in.nextLine();
                    System.out.print("Місце проживання - ");
                    String placeOfResidence = in.nextLine();
                    LocalDate birthday = null;
                    do {
                        parseOk = true;
                        try {
                            System.out.print("Введіть вашу дату народження у форматі \"2007-12-03\" - ");
                            birthday = LocalDate.parse(in.next());
                        } catch (Exception e) {
                            in.nextLine();
                            parseOk = false;
                        }
                    } while (!parseOk);
                    System.out.println(each.addAppointment(new Patient(name, surname, birthday, placeOfResidence)));
                }
            }
        } while (!found);
    }
}
