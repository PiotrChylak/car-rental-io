package com.example.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleCSVHandler {
    public void saveVehiclesToCsv(Vehicle[] vehicles) {
        try {
            FileWriter writer = new FileWriter("vehicles.csv");
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.toCSV());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveVehicleToCsv(Vehicle vehicle) {
        try {
            FileWriter writer = new FileWriter("vehicles.csv", true);
            writer.write(vehicle.toCSV());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> getVehiclesFromCSV(String path) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 8) {
                    String id = fields[0];
                    String model = fields[1];
                    String brand = fields[2];
                    int year = Integer.parseInt(fields[3]);
                    boolean isRented = Boolean.parseBoolean(fields[4]);
                    String plate = fields[5];
                    String ownerId = fields[6];
                    String renterId = fields[7];
                    float dailyFee = Float.parseFloat(fields[8]);
                    if(ownerId.startsWith("C")){
                        Car car = new Car(model, year, plate, brand, dailyFee, ownerId, id);
                        car.renterId = renterId;
                        car.isRented = isRented;
                        vehicles.add(car);
                    } else if(ownerId.startsWith("M")){
                        String category = fields[9];
                        Motorcycle bike = new Motorcycle(model, year, plate, brand, category,dailyFee, ownerId, id);
                        bike.renterId = renterId;
                        bike.isRented = isRented;
                        vehicles.add(bike);
                    }
                }
            }
            System.out.println("Vehicles have been loaded from CSV file: " + path);
        } catch (IOException e) {
            System.err.println("Error reading from CSV file: " + e.getMessage());
        }
        return vehicles;
    }
}
