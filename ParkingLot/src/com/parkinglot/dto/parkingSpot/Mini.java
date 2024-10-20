package com.parkinglot.dto.parkingSpot;

public class Mini  extends ParkingSpot{
    public Mini(Integer floor) {
        super(floor, 20);
    }
    public int cost(int parkingHour){
        return parkingHour*getAmount();
    }
}
