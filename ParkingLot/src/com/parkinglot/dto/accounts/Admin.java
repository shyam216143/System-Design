package com.parkinglot.dto.accounts;

import com.parkinglot.dto.ParkingLot;

public class Admin extends Account {
    private ParkingLot parkingLot = ParkingLot.getInstance();
}
