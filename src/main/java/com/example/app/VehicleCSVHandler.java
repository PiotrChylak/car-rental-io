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
            FileWriter writer = new FileWriter("src/resources/vehicles.csv");
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
            FileWriter writer = new FileWriter("src/resources/vehicles.csv");
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
                    String model = fields[0];
                    String brand = fields[1];
                    int year = Integer.parseInt(fields[2]);
                    boolean isRented = Boolean.parseBoolean(fields[3]);
                    String plate = fields[4];
                    String ownerId = fields[5];
                    String renterId = fields[6];
                    float dailyFee = Float.parseFloat(fields[7]);
                    String id = fields[8];
                    if(id.startsWith("C")){
                        Car car = new Car(model, year, plate, brand, dailyFee, ownerId, id);
                        car.renterId = renterId;
                        car.isRented = isRented;
                        vehicles.add(car);
                    } else if(id.startsWith("M")){
                        // TODO add category handling for motorcycles
                        Motorcycle motorcycle = new Motorcycle(model, year, plate, brand,dailyFee, ownerId, id);
                        motorcycle.renterId = renterId;
                        motorcycle.isRented = isRented;
                        vehicles.add(motorcycle);
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
