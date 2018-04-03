package com.epam.dmitriy_abdulin.java.lesson2.appliances;

import com.epam.dmitriy_abdulin.java.lesson2.appliances.Type.TypeAppliances;


/**
 * Created by dima7 on 03.04.2018.
 */
public class Appliance implements IAppliances, Cloneable {
    private String brandAppliances;
    private TypeAppliances typeOfDevice;
    private int powerOfDevice;
    private boolean stateOfDevice;

    public Appliance(String brandAppliances, TypeAppliances typeOfDevice, int powerOfDevice, boolean stateOfDevice) {
        this.brandAppliances = brandAppliances;
        this.typeOfDevice = typeOfDevice;
        this.powerOfDevice = powerOfDevice;
        this.stateOfDevice = stateOfDevice;
    }

    @Override
    public String getBrandAppliances() {
        return brandAppliances;
    }

    @Override
    public boolean isStateOfDevice() {
        return stateOfDevice;
    }

    @Override
    public int getPower() {
        return powerOfDevice;
    }

    @Override
    public Appliance clone() throws CloneNotSupportedException {
        return (Appliance) super.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.brandAppliances).append("(").append(this.typeOfDevice).append(" : ")
                .append(this.powerOfDevice).append(" : ")
                .append(this.isStateOfDevice()? "on" : "off").append(")");
        return sb.toString();
    }

    @Override
    public int compareTo(IAppliances devToCompare) {
        int result;
        result = Boolean.compare(isStateOfDevice(), devToCompare.isStateOfDevice());
        if (result != 0) return result;
        result = Integer.compare(getPower(), devToCompare.getPower());
        return result;
    }
}
