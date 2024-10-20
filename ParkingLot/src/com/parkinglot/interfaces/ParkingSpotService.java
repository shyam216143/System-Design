package com.parkinglot.interfaces;

import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.enums.ParkingSpotEnum;

public interface ParkingSpotService {
    ParkingSpot createParkingSpot(ParkingSpotEnum parkingSpotEnum, Integer floorNum, int amount);
}
