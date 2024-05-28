package com.example.app.model;

import com.example.app.IDGenerator;

public class Car extends Vehicle {

    public Car(String brand, String model, String plate, String id, int year, float dailyFee, String ownerId){
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