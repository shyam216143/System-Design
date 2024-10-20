package com.parkinglot.interfaces;

import com.parkinglot.dto.vehicle.ParkingTicket;
import com.parkinglot.dto.vehicle.Vehicle;
import com.parkinglot.exceptions.InvalidTicketException;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);
    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
