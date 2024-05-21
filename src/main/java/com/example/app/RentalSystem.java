package com.example.app;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RentalSystem {
    List<Vehicle> availableVehicles = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
        System.out.println("Vehicle made available: " + vehicle.getModel());
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println(user.getUsername() + " registered successfully with ID: " + user.getId());
    }

    public void transferMoneyToLender(User lender, double amount) {
        System.out.println("Transferred $" + amount + " to Lender: " + lender.getName());
    }

    public void rentVehicle(String plate, Borrower loggedUser) {
        if (loggedUser.rentedVehicle != null) {
            System.out.println("You have already rented a vehicle: " + loggedUser.rentedVehicle.getModel());
            return;
        }
        Vehicle vehicle = availableVehicles.stream().filter(v -> v.plate == plate).findFirst().orElse(null);
        if (vehicle == null) {
            System.out.println("Vehicle not found with plate: " + plate);
            return;
        }
        if (vehicle.isRented) {
            System.out.println("Vehicle is already rented: " + vehicle.getModel());
            return;
        }
        vehicle.rent();
        loggedUser.rentedVehicle = vehicle;
        System.out.println("Vehicle rented successfully: " + vehicle.getModel());
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

    public void saveUsersToCSV(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (User user : users) {
                writer.write(user.toCSV() + "\n");
            }
            System.out.println("Users have been saved to CSV file: " + path);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
    public void getUsersFromCSV(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 7) {
                    String id = fields[0];
                    String name = fields[1];
                    String lastName = fields[2];
                    String username = fields[3];
                    String password = fields[4];
                    int moneyBalance = Integer.parseInt(fields[5]);
                    Enum<ROLES> role = ROLES.valueOf(fields[6]);

                    // TODO adding users from CSV file
                }
            }
            System.out.println("Users have been loaded from CSV file: " + path);
        } catch (IOException e) {
            System.err.println("Error reading from CSV file: " + e.getMessage());
        }
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