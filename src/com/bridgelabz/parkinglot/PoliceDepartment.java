package com.bridgelabz.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PoliceDepartment {

    /*
    @desc: go through all the parking lots and search for vehicle with given color
    @params: parking and color to be searched
    @return: List of {parking lot number , position}
     */
    public List<int[]> getAllVehiclesOfColor(Parking parking, String color) {
        List<ParkingLot> parkingLots = parking.getParkingLots();
        List<int[]> res = new ArrayList<>();

        for (int lotNo = 0; lotNo < parking.getParkingLotsCount(); lotNo++) {
            List<Vehicle> vehicleList = parkingLots.get(lotNo).getVehicles();
            for (int pos = 0; pos < vehicleList.size(); pos++) {
                if (vehicleList.get(pos) != null && Objects.equals(vehicleList.get(pos).getColor(), color)) {
                    res.add(new int[]{lotNo + 1, pos + 1});
                }
            }
        }
        return res;
    }

    public List<int[]> getAllVehiclesOfBrand(Parking parking,String brand){
        List<ParkingLot> parkingLots = parking.getParkingLots();
        List<int[]> res = new ArrayList<>();

        for (int lotNo = 0; lotNo < parking.getParkingLotsCount(); lotNo++) {
            List<Vehicle> vehicleList = parkingLots.get(lotNo).getVehicles();
            for (int pos = 0; pos < vehicleList.size(); pos++) {
                if (vehicleList.get(pos) != null && Objects.equals(vehicleList.get(pos).getName(), brand)) {
                    res.add(new int[]{lotNo + 1, pos + 1});
                }
            }
        }
        return res;
    }
}
