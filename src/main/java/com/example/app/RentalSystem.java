package com.example.app;

import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    List<Vehicle> availableVehicles = new ArrayList<>();
    List<User> users = new ArrayList<>();

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

    public void rentVehicle(int car_id, User loggedUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rentVehicle'");
    }

    public void returnVehicle(Vehicle rentedVehicle, User loggedUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnVehicle'");
    }
    public void getUsersFromCSV(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsersFromCSV'");
    }
    public void getVehiclesFromCSV(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVehiclesFromCSV'");
    }
    public void saveUsersToCSV(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUsersToCSV'");
    }
    public void saveVehiclesToCSV(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveVehiclesToCSV'");
    }
}