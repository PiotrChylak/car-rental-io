package handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.model.Car;
import com.example.app.model.Motorcycle;
import com.example.app.model.Vehicle;

public class VehicleCSVHandler implements VehicleHandler{
    public static void saveVehicles(List<Vehicle> availableVehicles, String path) {
        try {
            FileWriter writer = new FileWriter(path, false);
            for (Vehicle vehicle : availableVehicles) {
                writer.write(vehicle.toCSV());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveVehicle(Vehicle vehicle, String path) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(vehicle.toCSV());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> getVehicles(String path) {
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
                        Car car = new Car(brand, model, plate, id, year, dailyFee, ownerId);
                        car.renterId = renterId;
                        car.isRented = isRented;
                        vehicles.add(car);
                    } else if(id.startsWith("M")){
                        Motorcycle motorcycle = new Motorcycle(brand, model, plate, id, year, dailyFee, ownerId);
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
