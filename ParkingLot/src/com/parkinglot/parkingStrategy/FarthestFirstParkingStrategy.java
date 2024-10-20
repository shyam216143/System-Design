package com.parkinglot.parkingStrategy;

import com.parkinglot.dto.ParkingLot;
import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.enums.ParkingSpotEnum;
import com.parkinglot.exceptions.SpotNotFoundException;

import java.util.List;

public class FarthestFirstParkingStrategy implements Strategy {
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpotList = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(parkingSpotList.isEmpty()){
            throw new SpotNotFoundException("Spot not found in farthest first strategy");
        }
        return parkingSpotList.getLast();
    }
}
