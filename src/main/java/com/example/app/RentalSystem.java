package com.example.app;

import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private List<Vehicle> availableVehicles = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
        System.out.println("Vehicle made available: " + vehicle.getModel());
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    public void transferMoneyToLender(User lender, double amount) {
        System.out.println("Transferred $" + amount + " to Lender: " + lender.getName());
    }
}