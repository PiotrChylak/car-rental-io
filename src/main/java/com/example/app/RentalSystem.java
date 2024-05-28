package com.example.app;

import java.util.ArrayList;
import java.util.List;

import com.example.app.model.Borrower;
import com.example.app.model.Lender;
import com.example.app.model.User;
import com.example.app.model.Vehicle;

import handlers.UserCSVHandler;
import handlers.VehicleCSVHandler;

public class RentalSystem {
    List<Vehicle> availableVehicles = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public RentalSystem() {
        users = UserCSVHandler.getUsers("src/resources/user.csv");
        availableVehicles = VehicleCSVHandler.getVehicles("src/resources/vehicles.csv");
    }

    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
        System.out.println("Vehicle made available: " + vehicle.getModel());
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println(user.getUsername() + " registered successfully with ID: " + user.getId());
        UserCSVHandler.saveUser(user, "src/resources/user.csv");
    }

    public boolean transferMoneyToLenderFromBorrower(User borrower ,User lender, float amount) {
        System.out.println("Transferred $" + amount + " to Lender: " + lender.getName());
        return Payment.processPayment(borrower,lender, amount);
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

    public void rentVehicle(String plate, Borrower loggedUser, int duration) {
        if (loggedUser.rentedVehicleID == null) {
            System.out.println("You have already rented a vehicle: " + availableVehicles.stream()
                    .filter(v -> v.plate.equals(loggedUser.rentedVehicleID)).findFirst().get().getModel());
            return;
        }
        Vehicle vehicle = vehicleAvability(plate);
        Lender lender = (Lender) users.stream().filter(v -> (v.getId().equals(vehicle.ownerId))).findFirst()
                .orElse(null);
        if (lender.confirmRentRequest(loggedUser, vehicle)) {
            vehicle.rent();
            loggedUser.rentedVehicleID = vehicle.id;
            System.out.println("Vehicle rented successfully: " + vehicle.getModel());
            if (transferMoneyToLenderFromBorrower(loggedUser, lender, vehicle.dailyFee * duration)) {
                UserCSVHandler.saveUsers(users, "src/resources/user.csv");
                VehicleCSVHandler.saveVehicles(availableVehicles, "src/resources/vehicles.csv");
            }
        } else {
            System.out.println("Your request was denied by the owner of the car");
        }
    }

    public void returnVehicle(Borrower loggedUser) {
        if (loggedUser.rentedVehicleID == null) {
            System.out.println("You have not rented any vehicle");
            return;
        }
        availableVehicles.stream().filter(v -> v.id.equals(loggedUser.rentedVehicleID)).findFirst().get().isRented = false;
        loggedUser.rentedVehicleID = null;
        System.out.println("Vehicle returned successfully");
        UserCSVHandler.saveUsers(users, "src/resources/user.csv");
        VehicleCSVHandler.saveVehicles(availableVehicles, "src/resources/vehicles.csv");
    }
}