package com.example.app;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.app.model.Car;
import com.example.app.model.Motorcycle;
import com.example.app.model.Vehicle;

import handlers.VehicleCSVHandler;

public class VehicleCsvHandlerTest {
    @Test
    void testSaveVehiclesToCSV() {
        String path = "vehicles.csv";
        Car car = new Car("Toyota", "Corolla", "123-ABC", "C1", 2020, 50, "L1");
        Motorcycle motorcycle = new Motorcycle("Yamaha", "YZF-R1", "456-DEF", "M1", 2021, 100, "L2");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(motorcycle);
        VehicleCSVHandler.saveVehicles(vehicles, path);
        VehicleCSVHandler.getVehicles(path).forEach(v -> {
            if (v instanceof Car) {
                Car c = (Car) v;
                assert c.getBrand().equals("Toyota");
                assert c.getModel().equals("Corolla");
                assert c.getPlate().equals("123-ABC");
                assert c.getId().equals("C1");
                assert c.getYear() == 2020;
                assert c.getDailyFee() == 50;
                assert c.getOwnerId().equals("L1");
            } else if (v instanceof Motorcycle) {
                Motorcycle m = (Motorcycle) v;
                assert m.getBrand().equals("Yamaha");
                assert m.getModel().equals("YZF-R1");
                assert m.getPlate().equals("456-DEF");
                assert m.getId().equals("M1");
                assert m.getYear() == 2021;
                assert m.getDailyFee() == 100;
                assert m.getOwnerId().equals("L2");
            }
        });
        System.err.println("testSaveVehiclesToCSV passed");
    }
}
