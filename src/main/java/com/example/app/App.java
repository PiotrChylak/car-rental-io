package com.example.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creating system components
        RentalSystem system = new RentalSystem();
        Authentication auth = new Authentication(); // TODO: make Authentication singleton
        User loggedUser = null;
        TextHandler textH = new TextHandler(scanner, system, auth);
        UserCSVHandler userCSV = new UserCSVHandler();


        Car car1 = new Car("Toyota", 2020,"LUB123","Corolla");
        system.addVehicle(car1);
        //system.getVehiclesFromCSV("vehicles.csv")
        while (true) {
            textH.displayMainMenu();
            int option = scanner.nextInt();
            if (option == 1) {
                textH.registration();
            }
            else if (option == 2) {
            loggedUser = textH.login();
            if (loggedUser != null) {
                System.out.println("Login successful");
                break;
            } else {
                System.out.println("Login failed");
            }
        }}
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Vehicle Lending System");
            System.out.println("1. Rent Vehicle");
            System.out.println("2. Return Vehicle");
            if (loggedUser instanceof Lender) {
                System.out.println("3. Add Vehicle");
            }
            if (loggedUser instanceof Borrower) {
                System.out.println("4. Add Comment");
            }

            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    int i = 0;
                    for (Vehicle vehicle : system.availableVehicles) {
                        System.out.println(i++ +" "+vehicle.getModel()+" "+vehicle.plate);
                    }
                    System.out.println("Choose a vehicle to rent:");
                    String plate = scanner.next();
                    system.rentVehicle(plate,(Borrower) loggedUser);
                    break;
                case 2:
                    if (loggedUser instanceof Borrower) {
                        system.returnVehicle((Borrower) loggedUser);
                    } else {
                        System.out.println("You are not a borrower");
                    }
                    break;
                case 3:
                    if (loggedUser instanceof Lender) {
                        System.out.println("Enter vehicle type: m for motorcycle, c for car");
                        String type = scanner.next();
                        System.out.println("Enter vehicle model:");
                        String model = scanner.next();
                        System.out.println("Enter vehicle year:");
                        int year = scanner.nextInt();
                        System.out.println("Enter vehicle plate:");
                        plate = scanner.next();
                        if (system.availableVehicles.stream().anyMatch(v -> v.plate.equals(plate))) {
                            System.out.println("Vehicle with plate " + plate + " already exists");
                            break;
                        }
                        System.out.println("Enter vehicle brand:");
                        String brand = scanner.next();
                        if (type.equals("m")) {
                            System.out.println("Enter motorcycle category:");
                            String category = scanner.next();
                            Motorcycle vehicle = new Motorcycle(model, year, plate, brand,category);
                            system.addVehicle(vehicle);
                        } else if (type.equals("c")) {
                            Car vehicle = new Car(model, year, plate, brand);
                            system.addVehicle(vehicle);
                        } else {
                            System.out.println("Invalid vehicle type");
                        }
                    } else {
                        System.out.println("You are not a lender");
                    }
                    break;
                case 4:
                    //system.addComment("This is a comment"); //TODO: Think of idea where to store comment and how to implement this
                    break;
                case 5:
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