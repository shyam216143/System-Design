package com.parkinglot.parkingStrategy;

import com.parkinglot.dto.ParkingLot;
import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.enums.ParkingSpotEnum;
import com.parkinglot.exceptions.SpotNotFoundException;

import java.util.List;

public class NearestFirstParkingStrategy implements Strategy {
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpotList = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(parkingSpotList.isEmpty()){
            throw new SpotNotFoundException("Spot not found in nearest first strategy");
        }
        return parkingSpotList.getFirst();
    }
}
