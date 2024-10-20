package com.parkinglot.dto.vehicle;

import com.parkinglot.enums.ParkingSpotEnum;

public class Truck extends Vehicle {

    public Truck() {
        super(ParkingSpotEnum.LARGE);
    }
}
