package com.parkinglot.dto.parkingSpot.spotDecorator;

import com.parkinglot.dto.parkingSpot.ParkingSpot;

public class Wash extends SpotDecorator {

    public Wash(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHour) {
        return parkingSpot.cost(parkingHour)+20;
    }
}
