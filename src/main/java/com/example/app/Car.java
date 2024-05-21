package com.example.app;

public class Car extends Vehicle {

    public Car(String model, int year, String plate, String brand) {
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.brand = brand;
        this.isRented = false;
    }
    // Car-specific functionality can be added here
}