package com.parkinglot.dto.parkingSpot.spotDecorator;

import com.parkinglot.dto.parkingSpot.ParkingSpot;

public abstract class SpotDecorator extends ParkingSpot {
    protected ParkingSpot parkingSpot;

    public SpotDecorator(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
