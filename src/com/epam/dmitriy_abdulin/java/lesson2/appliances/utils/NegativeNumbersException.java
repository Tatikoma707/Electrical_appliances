package com.epam.dmitriy_abdulin.java.lesson2.appliances.utils;

/**
 * Created by dima7 on 01.05.2018.
 */
public class NegativeNumbersException extends Throwable {
    private Integer number;

    public NegativeNumbersException(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getMessage() {
        return "You are not allowed to enter negative numbers here: " + this.getNumber();
    }
}
