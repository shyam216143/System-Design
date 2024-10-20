package com.parkinglot.services;

import com.parkinglot.dto.DisplayBoard;
import com.parkinglot.dto.ParkingEvent;
import com.parkinglot.enums.ParkingEventType;
import com.parkinglot.enums.ParkingSpotEnum;
import com.parkinglot.interfaces.DisplayService;
import com.parkinglot.interfaces.Observer;

public class DisplayServiceImpl implements DisplayService, Observer {

    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
        Integer currCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(currCount == null){
            currCount =0;
        }
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, currCount + change);
    }

    @Override
    public void update(ParkingEvent event) {
        int currCount = DisplayBoard.getInstance().getFreeParkingSpots().get(event.getParkingSpotEnum());
        int change = 1;
        if(event.getEventType().equals(ParkingEventType.ENTRY)){
            change =-1;
        }
        int newCount = currCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(event.getParkingSpotEnum(), newCount);
    }
}
