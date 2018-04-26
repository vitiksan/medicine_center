package com.makh.support;

import com.makh.domain.Doctor;
import com.makh.domain.Human;

import java.io.*;
import java.util.ArrayList;

public class Serializator {
    private final static String directory = "src/main/resources/";

    public static void saveData(String path, ArrayList<Doctor> obj) {
        try {
            FileOutputStream someFile = new FileOutputStream(directory + path + ".ser");
            ObjectOutputStream someObj = new ObjectOutputStream(someFile);
            someObj.writeObject(obj);
            someFile.close();
            someObj.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Doctor> getData(String path) {
        ArrayList<Doctor> temp = null;
        try {
            FileInputStream someFile = new FileInputStream(directory + path + ".ser");
            ObjectInputStream someObj = new ObjectInputStream(someFile);

            temp = (ArrayList<Doctor>) someObj.readObject();
            for (Doctor doctor : temp) {
                if (doctor.getId() > Human.get_id()) Human.set_id(doctor.getId());
            }
            someFile.close();
            someObj.close();

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            return null;
        }
        return temp;
    }
}
