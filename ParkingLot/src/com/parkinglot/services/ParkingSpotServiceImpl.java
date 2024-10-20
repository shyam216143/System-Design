package com.parkinglot.services;

import com.parkinglot.dto.ParkingLot;
import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.enums.ParkingSpotEnum;
import com.parkinglot.interfaces.DisplayService;
import com.parkinglot.interfaces.ParkingSpotService;

import java.lang.reflect.*;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    DisplayService displayService = new DisplayServiceImpl();

    @Override
    public ParkingSpot createParkingSpot(ParkingSpotEnum parkingSpotEnum, Integer floorNum, int amount) {
        try {
            ParkingSpot parkingSpot = (ParkingSpot) parkingSpotEnum.getParkingSpotClass().getConstructor(Integer.class).newInstance(floorNum);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
            displayService.update(parkingSpotEnum, 1);
            return parkingSpot;

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
