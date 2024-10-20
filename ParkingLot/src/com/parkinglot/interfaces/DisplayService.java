package com.parkinglot.interfaces;

import com.parkinglot.enums.ParkingSpotEnum;

public interface DisplayService {
    void update(ParkingSpotEnum parkingSpotEnum, int change);
}
