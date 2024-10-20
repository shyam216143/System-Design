package com.parkinglot.dto.vehicle;

import com.parkinglot.enums.ParkingSpotEnum;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vehicle {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private int id;
    private ParkingSpotEnum parkingSpotEnum;

    public int getId() {
        return id;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
    }

    public Vehicle(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
        this.id = counter.incrementAndGet();
    }
}
