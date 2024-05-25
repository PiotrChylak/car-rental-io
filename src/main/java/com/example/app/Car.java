package com.example.app;

public class Car extends Vehicle {

    public Car(String model, int year, String plate, String brand,float dailyFee,String ownerId, String id){
        if(id == null)
            this.id = IDGenerator.generateVehicleID("C");
        else
            this.id = id;
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