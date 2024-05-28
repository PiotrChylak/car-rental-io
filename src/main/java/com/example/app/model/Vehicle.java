package com.example.app.model;

public abstract class Vehicle {
    public String model;
    public String brand;
    public int year;
    public boolean isRented;
    public String plate;
    public String id;
    public String ownerId;
    public String renterId;
    public float dailyFee;

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getPlate() {
        return plate;
    }

    public String getId() {
        return id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getRenterId() {
        return renterId;
    }

    public float getDailyFee() {
        return dailyFee;
    }

    public String toCSV(){
        return model + "," + brand + "," + year + "," + isRented + "," + plate + ","
                + ownerId + "," + renterId + "," + dailyFee + "," + id + "\n";
    }

    public void rent() {
        isRented = true;
    }
}