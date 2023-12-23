package com.bridgelabz.parkinglot;

import java.util.List;
import java.util.ArrayList;


public class ParkingLot {
    public static final int CAPACITY = 100;
    private List<Vehicle> parkingLots;

    public ParkingLot() {
        this.parkingLots = new ArrayList<>();
        for (int i = 0; i < CAPACITY; i++) {
            parkingLots.add(null);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < CAPACITY; i++) {
            if (parkingLots.get(i) == null) {
                System.out.println("Vehicle parked at parking lot " + (i + 1));
                parkingLots.set(i, vehicle);
                return true;
            }
        }
        System.out.println("Parking lot is full");
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (int i = 0; i < CAPACITY; i++) {
            if (vehicle == parkingLots.get(i)) {
                System.out.println("Vehicle unparked from parking lot " + (i + 1));
                parkingLots.set(i, null);
                return true;
            }
        }
        System.out.println("Vehicle not parked in this parking.");
        return false;
    }
}
