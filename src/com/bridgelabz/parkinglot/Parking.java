package com.bridgelabz.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private final List<ParkingLot> parkingLots;
    private final int parkingLotsCount;

    /*
    @desc: constructor with number of lots count
     */
    public Parking(int parkingLotsCount) {
        this.parkingLotsCount = parkingLotsCount;
        parkingLots = new ArrayList<>();
        for (int i = 0; i < parkingLotsCount; i++) {
            parkingLots.add(null);
        }
    }

    /*
    @desc: add the newly constructed parking lot to current parking
    @params: parkingLot to be added
    return: boolean
     */
    public boolean addLot(ParkingLot parkingLot) {
        for (int i = 0; i < parkingLotsCount; i++) {
            if (parkingLots.get(i) == null) {
                System.out.println("Parking lot added to parking...");
                parkingLots.add(i, parkingLot);
                return true;
            }
        }
        System.out.println("Parking is full...can't add new lot.");
        return false;
    }

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }

    /*
    @desc: returns position of given vehicle parked (1 based indexing)
    @params: vehicle
    @return: position at which vehicle is parked, -1 if vehicle is not in this parking lot
     */
    public int[] getPositionOfVehicle(Vehicle vehicle) {
        //[parking lot number,position in given lot]
        for (int j = 0; j < parkingLotsCount; j++) {
            List<Vehicle> vehicleList = parkingLots.get(j).getVehicles();
            for (int i = 0; i < vehicleList.size(); i++) {
                if (vehicleList.get(i) == vehicle) {
                    System.out.println("Your vehicle is parked at lot " + (j + 1) + " at position " + (i + 1));
                    return new int[]{j + 1, i + 1};
                }
            }
        }
        System.out.println("Your vehicle is not parked here...");
        return new int[]{-1, -1};
    }

    /*
    @desc: park to lot having the nearest free space
    @params: vehicle
    @return : position at which vehicle was parked
     */
    public int[] parkToNearestFree(Vehicle vehicle) {
        int position = 0;
        boolean hasParking = true;
        while (hasParking) {
            hasParking = false;
            for (int i = 0; i < parkingLotsCount; i++) {
                List<Vehicle> vehicleList = parkingLots.get(i).getVehicles();
                if (vehicleList.size() > position) {
                    if (vehicleList.get(position) == null) {
                        System.out.println("Vehicle parked in parking lot " + (i + 1) + " at position " + (position + 1));
                        parkingLots.get(i).parkVehicle(vehicle);
                        return new int[]{i + 1, position + 1};
                    }
                    hasParking = true;
                }
            }
            position++;
        }
        System.out.println("Complete parking is full...");
        return new int[]{-1, -1};
    }

    /*
    @desc: given the vehicle according to evenly distribution
    @params: vehicle
    @return: position at which vehicle was parked
     */
    public int[] parkEvenly(Vehicle vehicle) {
        int minAt = -1;
        int parkedCount = Integer.MAX_VALUE;
        for (int i = 0; i < parkingLotsCount; i++) {
            int cnt = parkingLots.get(i).getParkedCount();
            if (cnt != parkingLots.get(i).getCapacity() && cnt < parkedCount) {
                parkedCount = cnt;
                minAt = i;
            }
        }

        if (minAt != -1) {
            for (int i = 0; i < parkingLots.get(minAt).getVehicles().size(); i++) {
                Vehicle v = parkingLots.get(minAt).getVehicles().get(i);
                if (v == null) {
                    parkingLots.get(minAt).parkVehicle(vehicle);
                    System.out.println("Vehicle parked in parking lot " + (minAt + 1) + " at position " + (i + 1));
                    return new int[]{minAt + 1, i + 1};
                }
            }
        }
        System.out.println("Complete parking is full...");
        return new int[]{-1, -1};
    }
}
