package com.parkinglot.dto.parkingSpot.spotDecorator;

import com.parkinglot.dto.parkingSpot.ParkingSpot;

public class Electric extends SpotDecorator {

    public Electric(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHour){
        return parkingSpot.cost(parkingHour)+50;
    }
}
