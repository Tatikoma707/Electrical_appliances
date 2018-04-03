package com.epam.dmitriy_abdulin.java.lesson2.appliances;

import java.util.Comparator;

/**
 * Created by dima7 on 03.04.2018.
 */
public class SortByState implements Comparator<IAppliances> {
    @Override
    public int compare(IAppliances o1, IAppliances o2) {
        if (!o1.isStateOfDevice() && o2.isStateOfDevice()) {
            return 1;
        } else if (o1.isStateOfDevice() && !o2.isStateOfDevice()) {
            return -1;
        } else return 0;
    }
}
