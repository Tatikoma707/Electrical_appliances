package com.epam.dmitriy_abdulin.java.lesson2.appliances.utils;

import java.io.*;

/**
 * Created by dima7 on 08.05.2018.
 */
public class Serializator {
    public static void writeFile(String fileName, Object object) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Appliance readFile(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Appliance appliance = (Appliance) in.readObject();
            in.close();
            fileIn.close();
            return appliance;
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return null;
    }
}
