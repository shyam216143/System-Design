package com.parkinglot.interfaces;

import com.parkinglot.dto.ParkingEvent;

public interface Observer {
    void update(ParkingEvent event);
}
