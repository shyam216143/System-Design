package com.parkinglot.enums;

import com.parkinglot.dto.parkingSpot.*;

public enum ParkingSpotEnum {
    COMPACT(Compact.class),
    MINI(Mini.class),
    LARGE(Large.class);
    private Class parkingSpot;
    ParkingSpotEnum(Class parkingSpotClass) {
        this.parkingSpot = parkingSpotClass;
    }
    public Class getParkingSpotClass() {
        return this.parkingSpot;
    }
}
