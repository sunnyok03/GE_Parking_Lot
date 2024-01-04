package com.bridgelabz.parkinglot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
@desc: police department class to query on parking with given specifications
 */
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

    /*
@desc: go through all the parking lots and search for vehicle with given brand
@params: parking and brand to be searched
@return: List of {parking lot number , position}
 */
    public List<int[]> getAllVehiclesOfBrand(Parking parking, String brand) {
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

    /*
    @desc: get location,number,name of given brand and colored vehicles
    @params: parking, color and brand to be searched
    @return: List of {parking lot number, position}
     */
    public List<int[]> getAllVehiclesOfBrandAndColor(Parking parking, String brand, String color) {
        List<ParkingLot> parkingLots = parking.getParkingLots();
        List<int[]> res = new ArrayList<>();

        for (int lotNo = 0; lotNo < parking.getParkingLotsCount(); lotNo++) {
            List<Vehicle> vehicleList = parkingLots.get(lotNo).getVehicles();
            for (int pos = 0; pos < vehicleList.size(); pos++) {
                if (vehicleList.get(pos) != null && Objects.equals(vehicleList.get(pos).getName(), brand) && Objects.equals(vehicleList.get(pos).getColor(), color)) {
                    res.add(new int[]{lotNo + 1, pos + 1});
                }
            }
        }
        return res;
    }

    /*
    @desc: get all the vehicles location parked in last minutess
    @params: parking, time in localDateTime
    return: list of positions of vehicles
     */
    public List<int[]> getRecentParkedVehicles(Parking parking, int minutes) {
        LocalDateTime time = LocalDateTime.now().minusMinutes(minutes); // we need all vehicles parked after this time
        List<ParkingLot> parkingLots = parking.getParkingLots();
        List<int[]> res = new ArrayList<>();

        for (int lotNo = 0; lotNo < parking.getParkingLotsCount(); lotNo++) {
            List<Vehicle> vehicleList = parkingLots.get(lotNo).getVehicles();
            for (int pos = 0; pos < vehicleList.size(); pos++) {
                LocalDateTime parkingTime = parkingLots.get(lotNo).getParkingTime(vehicleList.get(pos));
                if (vehicleList.get(pos) != null && time.isBefore(parkingTime)) {
                    res.add(new int[]{lotNo + 1, pos + 1});
                }
            }
        }
        return res;
    }
}
