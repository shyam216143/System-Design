package com.parkinglot.dto;

import com.parkinglot.dto.parkingSpot.ParkingSpot;
import com.parkinglot.enums.ParkingSpotEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private List<EntrancePanel> entrances;
    private List<ExitPanel> exits;
    private DisplayBoard displayBoard;
    private Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots;
    private Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots;
    private static ParkingLot parkingLot =null;

    private ParkingLot(String name){
        this.name = name;
        entrances = new ArrayList<EntrancePanel>();
        exits = new ArrayList<>();
        displayBoard = DisplayBoard.getInstance();
        freeParkingSpots = new HashMap<ParkingSpotEnum, List<ParkingSpot>>();
        occupiedParkingSpots = new HashMap<>();
        freeParkingSpots.put(ParkingSpotEnum.COMPACT, new ArrayList<>());
        freeParkingSpots.put(ParkingSpotEnum.MINI, new ArrayList<>());
        freeParkingSpots.put(ParkingSpotEnum.LARGE, new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotEnum.COMPACT, new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotEnum.MINI, new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotEnum.LARGE, new ArrayList<>());
    }

    public static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot("parkinglot");
        }
        return parkingLot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntrancePanel> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<EntrancePanel> entrances) {
        this.entrances = entrances;
    }

    public List<ExitPanel> getExits() {
        return exits;
    }

    public void setExits(List<ExitPanel> exits) {
        this.exits = exits;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public Map<ParkingSpotEnum, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    public Map<ParkingSpotEnum, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void setOccupiedParkingSpots(Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }

    public static ParkingLot getParkingLot() {
        return parkingLot;
    }

    public static void setParkingLot(ParkingLot parkingLot) {
        ParkingLot.parkingLot = parkingLot;
    }
}
