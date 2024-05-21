package com.example.app;

public class Car extends Vehicle {

    public Car(String model, int year, String plate, String brand,int dailyFee,String ownerId){
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.brand = brand;
        this.isRented = false;
        this.dailyFee = dailyFee;
        this.ownerId = ownerId;
        this.renterId = null;
    }
    // Car-specific functionality can be added here
}