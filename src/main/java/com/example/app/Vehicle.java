package com.example.app;

public abstract class Vehicle {
    protected String model;
    protected String brand;
    protected int year;
    protected boolean isRented;
    protected String plate;

    public String getModel() {
        return model;
    }

    public void rent() {
        isRented = true;
    }
}