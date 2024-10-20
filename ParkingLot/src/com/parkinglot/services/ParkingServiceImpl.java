package com.parkinglot.services;

import com.parkinglot.dto.ParkingEvent;
import com.parkinglot.dto.ParkingLot;
import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.dto.parkingSpot.spotDecorator.Wash;
import com.parkinglot.dto.vehicle.ParkingTicket;
import com.parkinglot.dto.vehicle.Vehicle;
import com.parkinglot.enums.ParkingEventType;
import com.parkinglot.enums.ParkingSpotEnum;
import com.parkinglot.exceptions.InvalidTicketException;
import com.parkinglot.interfaces.DisplayService;
import com.parkinglot.interfaces.Observer;
import com.parkinglot.interfaces.ParkingService;
import com.parkinglot.parkingStrategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    Strategy parkingStrategy;
    ParkingLot parkingLot;
    DisplayService displayService;
    List<Observer> observers;

    public ParkingServiceImpl(Strategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        parkingLot = ParkingLot.getInstance();
        displayService = new DisplayServiceImpl();
        observers = new ArrayList<>();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
        List<ParkingSpot> freeParkingSpot = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpot = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);
        try{
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);
            if(parkingSpot.isFree()){
                synchronized (parkingSpot){
                    if(parkingSpot.isFree()){
                        parkingSpot.setFree(false);
                        freeParkingSpot.remove(parkingSpot);
                        occupiedParkingSpot.add(parkingSpot);
                        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);
                        ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.ENTRY, parkingSpotEnum);
                        notifyAllObservers(parkingEvent);
//                        displayService.update(parkingSpotEnum, -1);
                        return parkingTicket;
                    }
                    entry(vehicle);
                }
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }

    private void addParkingSpotInFreeList(List<ParkingSpot> freeParkingSpots, ParkingSpot parkingSpot){
            freeParkingSpots.add(parkingSpot);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers(ParkingEvent parkingEvent) {
        for(Observer observer : observers){
           observer.update(parkingEvent);
        }
    }

    public void addWash(ParkingTicket parkingTicket) {
        parkingTicket.setParkingSpot(new Wash(parkingTicket.getParkingSpot()));
        return;
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if(parkingTicket.getVehicle().equals(vehicle)){
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            int amount = parkingSpot.getAmount();
            parkingSpot.setFree(true);
            parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
            addParkingSpotInFreeList(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()), parkingSpot);
            ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT, vehicle.getParkingSpotEnum());
            notifyAllObservers(parkingEvent);

//            displayService.update(vehicle.getParkingSpotEnum(), 1);
            return amount;
        }
        else{
            throw new InvalidTicketException("This is an invalid ticket");
        }

    }
}
