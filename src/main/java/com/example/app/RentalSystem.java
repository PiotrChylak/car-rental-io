package com.example.app;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RentalSystem {
    List<Vehicle> availableVehicles = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public RentalSystem(){
        users = UserCSVHandler.getUsersFromCSV("src/resources/user.csv");
    }

    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
        System.out.println("Vehicle made available: " + vehicle.getModel());
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println(user.getUsername() + " registered successfully with ID: " + user.getId());
        UserCSVHandler.saveUserToCSV("src/resources/user.csv", user);
    }

    public void transferMoneyToLender(User lender, double amount) {
        System.out.println("Transferred $" + amount + " to Lender: " + lender.getName());
    }

    public Vehicle vehicleAvability(String plate) {
        Vehicle vehicle = availableVehicles.stream().filter(v -> v.plate.equals(plate)).findFirst().orElse(null);
        if (vehicle == null) {
            System.out.println("Vehicle not found with plate: " + plate);
            return null;
        }
        if (vehicle.isRented) {
            System.out.println("Vehicle is already rented: " + vehicle.getModel());
            return null;
        }
        return vehicle;
    }
public void rentVehicle(String plate, Borrower loggedUser,int duration) {
        if (loggedUser.rentedVehicle != null) {
            System.out.println("You have already rented a vehicle: " + loggedUser.rentedVehicle.getModel());
            return;
        }
        Vehicle vehicle = vehicleAvability(plate);
        Lender lender = (Lender) users.stream().filter(v->(v.getId().equals(vehicle.ownerId))).findFirst().orElse(null);
        if(lender.confirmRentRequest(loggedUser,vehicle)){
            vehicle.rent();
            loggedUser.rentedVehicle = vehicle;
            System.out.println("Vehicle rented successfully: " + vehicle.getModel());
            if (Payment.processPayment(loggedUser,lender,vehicle.dailyFee*duration)){

            }
        }else {
            System.out.println("Your request was denied by the owner of the car");
        }
    }

    public void returnVehicle(Borrower loggedUser) {
        if (loggedUser.rentedVehicle == null) {
            System.out.println("You have not rented any vehicle");
            return;
        }
        loggedUser.rentedVehicle.isRented = false;
        loggedUser.rentedVehicle = null;
        System.out.println("Vehicle returned successfully");
    }

    public void getVehiclesFromCSV(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVehiclesFromCSV'");
    }

    public void saveVehiclesToCSV(String path) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveVehiclesToCSV'");
    }
}