package com.epam.dmitriy_abdulin.java.lesson2.appliances.utils;

import com.epam.dmitriy_abdulin.java.lesson2.appliances.types.TypeAppliances;
import com.epam.dmitriy_abdulin.java.lesson2.appliances.types.TypeLocation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 * Created by dima7 on 03.04.2018.
 */
@XmlRootElement
public class Appliance implements IAppliances, Cloneable, Serializable {
    private String brandAppliances;
    private TypeAppliances typeOfDevice;
    private int powerOfDevice;
    private boolean stateOfDevice;
    private String colorOfDevice;
    private TypeLocation location;

    public Appliance() {

    }

    public Appliance(String brandAppliances, TypeAppliances typeOfDevice, int powerOfDevice, boolean stateOfDevice, String colorOfDevice, TypeLocation location) {
        this.brandAppliances = brandAppliances;
        this.typeOfDevice = typeOfDevice;
        this.powerOfDevice = powerOfDevice;
        this.stateOfDevice = stateOfDevice;
        this.colorOfDevice = colorOfDevice;
        this.location = location;
    }

    @Override
    public String getBrandAppliances() {
        return brandAppliances;
    }

    @XmlElement
    public void setBrandAppliances(String brandAppliances) {
        this.brandAppliances = brandAppliances;
    }

    @XmlElement
    public void setTypeOfDevice(TypeAppliances typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    public TypeAppliances getTypeOfDevice() {
        return typeOfDevice;
    }

    @XmlElement
    public void setPowerOfDevice(int powerOfDevice) {
        this.powerOfDevice = powerOfDevice;
    }

    @Override
    public int getPowerOfDevice() {
        return powerOfDevice;
    }

    @Override
    public boolean isStateOfDevice() {
        return stateOfDevice;
    }

    @XmlElement
    public void setStateOfDevice(boolean stateOfDevice) {
        this.stateOfDevice = stateOfDevice;
    }

    @Override
    public String getColorOfDevice() {
        return colorOfDevice;
    }

    @XmlElement
    public void setColorOfDevice(String colorOfDevice) {
        this.colorOfDevice = colorOfDevice;
    }

    public TypeLocation getLocation() {
        return location;
    }

    @XmlElement
    public void setLocation(TypeLocation location) {
        this.location = location;
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
                .append(this.isStateOfDevice() ? "on" : "off").append(" : ")
                .append(this.colorOfDevice).append(" : ")
                .append(this.location).append(")");
        return sb.toString();
    }

    @Override
    public int compareTo(IAppliances devToCompare) {
        int result;
        result = Boolean.compare(isStateOfDevice(), devToCompare.isStateOfDevice());
        if (result != 0) return result;
        result = Integer.compare(getPowerOfDevice(), devToCompare.getPowerOfDevice());
        return result;
    }


}
