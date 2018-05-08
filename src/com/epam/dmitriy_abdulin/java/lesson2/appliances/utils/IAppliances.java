package com.epam.dmitriy_abdulin.java.lesson2.appliances.utils;

/**
 * Created by dima7 on 03.04.2018.
 */
public interface IAppliances extends Comparable<IAppliances> {
    String getBrandAppliances();

    boolean isStateOfDevice();

    int getPowerOfDevice();

    String getColorOfDevice();

    Appliance clone() throws CloneNotSupportedException;

    @Override
    int compareTo(IAppliances o);
}
