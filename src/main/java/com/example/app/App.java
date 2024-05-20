package com.example.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating system components
        RentalSystem system = new RentalSystem();
        Authentication auth = new Authentication();
        Payment payment = new Payment();

        // Creating users
        Lender lender = new Lender();
        lender.setId("1");
        lender.setName("Alice");
        lender.setLastName("Smith");

        Borrower borrower = new Borrower();
        borrower.setId("2");
        borrower.setName("Bob");
        borrower.setLastName("Johnson");

        // Registering users in the system
        system.registerUser(lender);
        system.registerUser(borrower);

        // Adding a vehicle
        Car car = new Car();
        car.model = "Toyota Corolla";
        car.brand = "Toyota";
        car.year = 2022;
        car.plate = "XYZ1234";

        lender.addVehicleToSystem(car);
        system.addVehicle(car);

        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Vehicle Lending System");
            System.out.println("1. Login");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    // Simple login simulation
                    System.out.println("Enter username:");
                    String username = scanner.next();
                    System.out.println("Enter password:");
                    String password = scanner.next();
                    auth.login(username, password);
                    break;
                case 2:
                    // Simulate renting a vehicle
                    borrower.rentVehicle(car);
                    break;
                case 3:
                    // Simulate returning a vehicle
                    borrower.returnVehicle(car);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
