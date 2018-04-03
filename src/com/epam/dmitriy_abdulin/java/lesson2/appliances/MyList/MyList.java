package com.epam.dmitriy_abdulin.java.lesson2.appliances.MyList;


import com.epam.dmitriy_abdulin.java.lesson2.appliances.Appliance;

/**
 * Created by dima7 on 03.04.2018.
 */
public class MyList<Appliance> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Appliance[] array = (Appliance[]) new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(Appliance item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    public Appliance get(int index) {
        return (Appliance) array[index];
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Appliance[] newArray = (Appliance[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
