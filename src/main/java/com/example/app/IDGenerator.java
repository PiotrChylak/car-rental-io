package com.example.app;
public class IDGenerator {
    private static int counter = 0;

    public static synchronized String generateID(String prefix) {
        return prefix + String.format("%03d", counter++);
    }
}
