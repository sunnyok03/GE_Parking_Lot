package com.bridgelabz.parkinglot;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(2);
        ParkingLot parkingLot = new ParkingLot(2);
        AirportSecurity airportSecurity = new AirportSecurity();
        ParkingLot parkingLot2 = new ParkingLot(3);
        parking.addLot(parkingLot);
        parking.addLot(parkingLot2);

        Vehicle v1 = new Vehicle("Vehicle 1", "blue", "Number 1", 4);
        Vehicle v2 = new Vehicle("Vehicle 2", "green", "Number 2", 4);

        parking.parkEvenly(v1);
        parking.parkEvenly(v2);
//
//        for (Vehicle vehicle : parkingLot.getVehicles()) {
//            System.out.println(vehicle);
//        }
//        System.out.println("------------");
//        for (Vehicle vehicle : parkingLot2.getVehicles()) {
//            System.out.println(vehicle);
//        }

    }
}