package com.bridgelabz.parkinglot;

/*
Vehicle class to store its name,color,number,capacity
 */
public class Vehicle {
    public String name;
    public String color;
    public String number;
    public int capacity;

    //constructor
    public Vehicle(String name, String color, String number, int capacity) {
        this.name = name;
        this.color = color;
        this.number = number;
        this.capacity = capacity;
    }
    /*
    @desc: returns color of current car
    @params:
    @return String (color)
     */
    public String getColor(){
        return this.color;
    }

    /*
    @desc: get brand name
    @params:
    @return: String
     */
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
