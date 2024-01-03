package com.bridgelabz.parkinglot;

import java.util.List;
import java.util.ArrayList;

/*
Parking lot class to store status at each position of the lot
 */
public class ParkingLot {
    private final List<Vehicle> vehicles;
    private final int capacity;
    private int parkedCount;

    //constructor
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            vehicles.add(null);
        }
        parkedCount = 0;
    }

    /*
    @desc: given a new vehicle check if it can be parked or not
    @params: vehicle
    @return: boolean (status if parked or not)
     */
    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < capacity; i++) {
            if (vehicles.get(i) == null) {
                System.out.println("Vehicle parked at position " + (i + 1));
                vehicles.set(i, vehicle);
                chargePrice(); // inform lot owner to charge for parking
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
        for (int i = 0; i < capacity; i++) {
            if (vehicle == vehicles.get(i)) {
                System.out.println("Vehicle unParked from position " + (i + 1));
                vehicles.set(i, null);
                parkedCount--;
                return true;
            }
        }
        System.out.println("Vehicle not parked in this parking lot.");
        return false;
    }

    /*
@desc:
@params:
@return: boolean (status if parking lot is full)
*/
    public boolean isFull() {
        if (parkedCount != capacity) {
            System.out.println("Current parking lot is not full.");
            return false;
        } else {
            System.out.println("Current parking lot is full.");
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
    @desc: check if parking lot has space or not
    @params:
    @return: boolean (status if parking lot has space)
    */
    public boolean hasSpace() {
        if (parkedCount < capacity) {
            System.out.println("Current parking lot is not full.");
            return true;
        } else {
            System.out.println("Current parking lot is full.");
            return false;
        }
    }

    /*
    @desc: charge if vehicle was parked
     */
    public void chargePrice() {
        System.out.println("Inform lot owner to charge for parking...");
    }

    /*
    @desc: return capacity of current lot
     */
    public int getCapacity() {
        return this.capacity;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }
}
