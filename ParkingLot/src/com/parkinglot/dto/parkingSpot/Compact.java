package com.parkinglot.dto.parkingSpot;

public class Compact extends ParkingSpot {
    public Compact(Integer floor) {
        super(floor, 40);
    }
    public int cost(int parkingHour){
        return parkingHour*getAmount();
    }
}
