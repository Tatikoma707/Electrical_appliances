package com.epam.dmitriy_abdulin.java.lesson2;

import com.epam.dmitriy_abdulin.java.lesson2.appliances.Appliance;
import com.epam.dmitriy_abdulin.java.lesson2.appliances.MyList.MyList;
import com.epam.dmitriy_abdulin.java.lesson2.appliances.Type.TypeAppliances;

/**
 * Created by dima7 on 03.04.2018.
 */
public class Solution {
    public static void main(String[] args) {
        Appliance kettleTefal = createAppliances("Tefal", TypeAppliances.KETTLE, 1000, true);
        Appliance tvSony = createAppliances("Sony", TypeAppliances.TV, 400, true);
        Appliance lampPhilips = createAppliances("Philips", TypeAppliances.LAMP, 200, false);
        Appliance computerHP = createAppliances("HP", TypeAppliances.COMPUTER, 500, false);
        Appliance cookerGefest = createAppliances("Gefest", TypeAppliances.COOKER, 1500, true);

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
                sumPower += myList.get(i).getPower();
        }
        System.out.println(sumPower);
    }

    public static MyList<Appliance> getAppliancesByPower(MyList<Appliance> list, int lowerBound, int upperBound) {
        MyList<Appliance> result = new MyList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPower() >= lowerBound && list.get(i).getPower() <= upperBound) {
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

    public static Appliance createAppliances(String brand, TypeAppliances type, int power, boolean isOn) {
        return new Appliance(brand, type, power, isOn);
    }
}
