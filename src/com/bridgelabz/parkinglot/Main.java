package com.bridgelabz.parkinglot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Vehicle v1 = new Vehicle("Vehicle 1", "blue", "Number 1", 4);
        parkingLot.allotSpace(v1);

        Vehicle v2 = new Vehicle("Vehicle 2", "green", "Number 2", 4);
        parkingLot.allotSpace(v2);
    }
}