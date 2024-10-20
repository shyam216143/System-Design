package com.parkinglot.dto.parkingSpot;

public class Large extends ParkingSpot {
    public Large(Integer floor) {
        super(floor, 50);
    }
    public int cost(int parkingHour){
        return parkingHour*getAmount();
    }
}
