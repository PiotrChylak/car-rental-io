package com.example.app;

public abstract class Vehicle {
    protected String model;
    protected String brand;
    protected int year;
    protected boolean isRented;
    protected String plate;
    protected String id;
    public String ownerId;
    public String renterId;
    public float dailyFee;

    public String getModel() {
        return model;
    }

    public String toCSV(){
        return model + "," + brand + "," + year + "," + isRented + "," + plate + ","
                + ownerId + "," + renterId + "," + dailyFee + "," + id + "\n";
    }

    public void rent() {
        isRented = true;
    }
}