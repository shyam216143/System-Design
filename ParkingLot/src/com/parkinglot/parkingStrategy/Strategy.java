package com.parkinglot.parkingStrategy;

import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.enums.ParkingSpotEnum;
import com.parkinglot.exceptions.SpotNotFoundException;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
