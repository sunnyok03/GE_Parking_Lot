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

    public int allotSpace(Vehicle vehicle) {
        for (int i = 0; i < CAPACITY; i++) {
            if (parkingLots.get(i) == null) {
                System.out.println("Vehicle parked at parking lot " + (i + 1));
                parkingLots.set(i, vehicle);
                return i + 1;
            }
        }
        System.out.println("Parking lot is full");
        return -1;
    }
}
