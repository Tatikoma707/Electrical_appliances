package com.epam.dmitriy_abdulin.java.lesson2;

import com.epam.dmitriy_abdulin.java.lesson2.appliances.types.TypeAppliances;
import com.epam.dmitriy_abdulin.java.lesson2.appliances.types.TypeLocation;
import com.epam.dmitriy_abdulin.java.lesson2.appliances.utils.*;

import java.util.Scanner;

/**
 * Created by dima7 on 03.04.2018.
 */
public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Appliance kettleTefal = createAppliances("Tefal", TypeAppliances.KETTLE, 100, true, "Black", TypeLocation.Kitchen);
            Appliance tvSony = createAppliances("Sony", TypeAppliances.TV, 400, true, "White", TypeLocation.Bedroom);
            Appliance lampPhilips = createAppliances("Philips", TypeAppliances.LAMP, 200, false, "Red", TypeLocation.Cabinet);
            Appliance computerHP = createAppliances("HP", TypeAppliances.COMPUTER, 500, false, "Black", TypeLocation.Cabinet);
            Appliance cookerGefest = createAppliances("Gefest", TypeAppliances.COOKER, 1500, true, "White", TypeLocation.Kitchen);

            MyList<Appliance> myList = new MyList<>();
            myList.add(kettleTefal);
            myList.add(tvSony);
            myList.add(lampPhilips);
            myList.add(computerHP);
            myList.add(cookerGefest);
            for (int i = 0; i < myList.size(); i++) {
                System.out.println(myList.get(i));
            }
            System.out.println("\nAppliances, whose power is in the range of 500 to 1000:");
            MyList<Appliance> sortByPower = getAppliancesByPower(myList, 500, 1000);
            for (int i = 0; i < sortByPower.size(); i++) {
                System.out.println(sortByPower.get(i));
            }
            System.out.println("\nAppliances, which are currently included in the outlet:");
            MyList<Appliance> sortAppliancesByState = getAppliancesByState(myList, true);
            for (int i = 0; i < sortAppliancesByState.size(); i++) {
                System.out.println(sortAppliancesByState.get(i));
            }

            System.out.print("\nTotal power consumption: ");
            Integer sumPower = 0;
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).isStateOfDevice())
                    sumPower += myList.get(i).getPowerOfDevice();
            }
            System.out.println(sumPower);
            Serializator.writeFile("Test.xml", kettleTefal);
            Appliance kettle = Serializator.readFile("Test.xml");
            System.out.println("\n" + kettle);
            XMLparser.writeObjectToXml("Test1.xml",computerHP);
            Appliance computer = XMLparser.readObjectFromXml("Test1.xml");
            System.out.println("\n" + computer);
        } catch (NegativeNumbersException e) {
            e.printStackTrace();
        }
    }

    public static MyList<Appliance> getAppliancesByPower(MyList<Appliance> list, int lowerBound, int upperBound) {
        MyList<Appliance> result = new MyList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPowerOfDevice() >= lowerBound && list.get(i).getPowerOfDevice() <= upperBound) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static MyList<Appliance> getAppliancesByState(MyList<Appliance> list, boolean state) {
        MyList<Appliance> result = new MyList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isStateOfDevice() == state) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static Appliance createAppliances(String brand, TypeAppliances type, int power, boolean isOn, String colorOfDevice, TypeLocation location) throws NegativeNumbersException {
        if (power < 0) {
            throw new NegativeNumbersException(power);
        }
        return new Appliance(brand, type, power, isOn, colorOfDevice, location);
    }
}
