package com.example.app;
public class IDGenerator {
    private static int userCounter = 0;
    private static int vehicleCounter = 0;

    public static synchronized String generateUserID(String prefix) {
        return prefix + String.format("%03d", userCounter++);
    }

    public static synchronized String generateVehicleID(String prefix) {
        return prefix + String.format("%03d", vehicleCounter++);
    }
}
