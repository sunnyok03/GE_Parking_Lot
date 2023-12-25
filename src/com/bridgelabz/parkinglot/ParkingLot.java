package com.bridgelabz.parkinglot;

import java.util.List;
import java.util.ArrayList;

/*
Parking lot class to store status at each position of the lot
 */
public class ParkingLot {
    public static final int CAPACITY = 100;
    private List<Vehicle> parkingLots;

    private int parkedCount;

    //constructor
    public ParkingLot() {
        this.parkingLots = new ArrayList<>();
        for (int i = 0; i < CAPACITY; i++) {
            parkingLots.add(null);
        }
        parkedCount = 0;
    }

    /*
    @desc: given a new vehicle check if it can be parked or not
    @params: vehicle
    @return: boolean (status if parked or not)
     */
    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < CAPACITY; i++) {
            if (parkingLots.get(i) == null) {
                System.out.println("Vehicle parked at parking lot " + (i + 1));
                parkingLots.set(i, vehicle);
                parkedCount++;
                return true;
            }
        }
        System.out.println("Parking lot is full");
        return false;
    }

    /*
@desc: given a vehicle check if it was parked or not
@params: vehicle
@return: boolean (status if unParked or not)
 */
    public boolean unParkVehicle(Vehicle vehicle) {
        for (int i = 0; i < CAPACITY; i++) {
            if (vehicle == parkingLots.get(i)) {
                System.out.println("Vehicle unparked from parking lot " + (i + 1));
                parkingLots.set(i, null);
                parkedCount--;
                return true;
            }
        }
        System.out.println("Vehicle not parked in this parking.");
        return false;
    }

    /*
@desc:
@params:
@return: boolean (status if parking lot is full)
*/
    public boolean isFull() {
        if (parkedCount == CAPACITY) {
            System.out.println("All parking lot is not full.");
            return false;
        } else {
            System.out.println("All parking lot is full.");
            return true;
        }
    }

    /*
    @desc: get count of parked vehicle
    @params:
    @return: parkedCount
     */
    public int getParkedCount() {
        return parkedCount;
    }

    /*
    @desc:
    @params:
    @return: boolean (status if parking lot has space)
    */
    public boolean hasSpace() {
        if (parkedCount < CAPACITY) {
            System.out.println("Parking lot is not full.");
            return true;
        } else {
            System.out.println("All parking lot is full.");
            return false;
        }
    }

    /*
    @desc: returns position of given vehicle parked (1 based indexing)
    @params: vehicle
    @return: position at which vehicle is parked, -1 if vehicle is not in this parking lot
     */
    public int getPositionOfVehicle(Vehicle vehicle) {
        for (int i = 0; i < CAPACITY; i++) {
            if (parkingLots.get(i) == vehicle) {
                return i + 1;
            }
        }
        return -1;
    }
}
