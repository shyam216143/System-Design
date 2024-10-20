package com.parkinglot.dto.vehicle;

import com.parkinglot.dto.parkingSpot.ParkingSpot;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private static final AtomicInteger ticketNumber = new AtomicInteger();
    private int id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime parkingTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.id = ticketNumber.incrementAndGet();
        this.parkingTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(LocalDateTime parkingTime) {
        this.parkingTime = parkingTime;
    }

    public int getParkingHours(){
        return 2;
    }
}
