package com.bridgelabz.parkinglot;

public class AirportSecurity {

    public boolean isFull(ParkingLot parkingLot) {
        if (parkingLot.isFull()) {
            System.out.println("Parking lot is full..Redirect the security staff.");
            return true;
        }
        System.out.println("Parking lot is not full..");
        return false;
    }


}
