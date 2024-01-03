package com.bridgelabz.parkinglot;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(2);
        ParkingLot parkingLot = new ParkingLot(2);
        AirportSecurity airportSecurity = new AirportSecurity();
        PoliceDepartment policeDepartment = new PoliceDepartment();
        ParkingLot parkingLot2 = new ParkingLot(3);
        parking.addLot(parkingLot);
        parking.addLot(parkingLot2);

        Vehicle v1 = new Vehicle("Vehicle 1", "blue", "Number 1", 4);
        Vehicle v2 = new Vehicle("Vehicle 2", "green", "Number 2", 4);
        Vehicle v3 = new Vehicle("Vehicle 3", "green", "Number 3", 6);

        parkingLot.parkVehicle(v2);
        parkingLot.parkVehicle(v1);
        parkingLot2.parkVehicle(v3);

        List<int[]> res = policeDepartment.getAllVehiclesOfBrandAndColor(parking, "Vehicle 1", "blue");
        System.out.println("Location of all the green colored vehicle in {parking lot, position}: ");
        for (int[] single : res) {
            System.out.println(Arrays.toString(single));
        }

    }
}