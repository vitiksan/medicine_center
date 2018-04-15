package com.makh;

import com.makh.domain.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 15.04.2018.
 */
public class Menu {
    private static ArrayList<Doctor> doctors = (Serializator.getData("db").equals(null)) ? new ArrayList<>() :
            Serializator.getData("db");
    private static int choose = -1;

    public static void start() {
        System.out.println("Вітаємо у медичному центрі\n");
        do {
            information();
            choose = chooses();
            done(choose);
        } while (choose != 0);
    }

    private static void done(int temp) {
        switch (temp) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
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
        Scanner in = new Scanner(System.in);
        int temp = -1;
        do {
            try {
                System.out.print("Зробіть вибір: ");
                temp = Integer.parseInt(in.next());
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
}
