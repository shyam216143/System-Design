package com.parkinglot.dto.vehicle;

import com.parkinglot.enums.ParkingSpotEnum;

public class Car extends Vehicle {

    public Car() {
        super(ParkingSpotEnum.COMPACT);
    }
}
