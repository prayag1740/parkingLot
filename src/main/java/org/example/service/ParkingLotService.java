package org.example.service;

import org.example.model.Car;
import org.example.model.ParkingLot;
import org.example.model.Slot;
import org.example.model.parking.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {

    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;

        for (int i = 1 ; i <= parkingLot.getCapacity(); i++){
            this.parkingStrategy.addSlot(i);
        }
    }
    public Integer parkCar(final Car car) {
        Integer nextFreeSlot = this.parkingStrategy.getNextSlot();
        parkingLot.park(car, nextFreeSlot);
        parkingStrategy.removeSlot(nextFreeSlot);
        return nextFreeSlot;
    }

    public void unParkCar(final Integer slotNo) {
        parkingLot.makeSlotFree(slotNo);
        parkingStrategy.addSlot(slotNo);
    }

    public List<Slot> getOccupiedSlots() {
        Map<Integer, Slot> allSlots = this.parkingLot.getSlots();
        List<Slot> occupiedSlots = new ArrayList<>() ;

        for (Slot slotVal : allSlots.values()) {
            if (!slotVal.isSlotFree()) {
                occupiedSlots.add(slotVal);
            }
        }

        return occupiedSlots;
    }

    public List<Slot> getSlotsForColor(String color) {
        Map<Integer, Slot> allSlots = this.parkingLot.getSlots();
        List<Slot> resultSlots = new ArrayList<>();

        for (Slot slotVal : allSlots.values()) {
            if (!slotVal.isSlotFree() && slotVal.getParkedCar().getColor().equals(color)){
                resultSlots.add(slotVal);
            }
        }
        return resultSlots;
    }

    public Integer getSLotFromRegistrationNo(String regNo) {
        List<Slot> occupiedSlots = getOccupiedSlots();
        boolean isRegNoPresent = false;

        for (Slot curSlot : occupiedSlots) {
            if (curSlot.getParkedCar().getRegistrationNo().equals(regNo)) {
                return curSlot.getSlotNo();
            }
        }
        return -1 ;
    }

    public Map<String, String> getCurrentSlotStatus() {
        List<Slot> occupiedSlots = getOccupiedSlots();
        Map<String, String> slotMap = new HashMap<>();
        for (Slot curSlot : occupiedSlots) {
            String slotNo = Integer.toString(curSlot.getSlotNo());
            if (!curSlot.isSlotFree()) {
                Car car = curSlot.getParkedCar();
                slotMap.put(slotNo, "Car parked with reg no " + car.getRegistrationNo() + " and color is " + car.getColor());
            } else {
                slotMap.put(slotNo, null);
            }
        }
        return slotMap ;
    }

    public List<String> getRegNoFromColor(String color) {
        List<String> regNos = new ArrayList<>();
        List<Slot> occupiedSlots = getOccupiedSlots();
        for (Slot curSlot : occupiedSlots) {
            if (!curSlot.isSlotFree()) {
                Car car = curSlot.getParkedCar();
                if (car.getColor().equals(color)) {
                    regNos.add(car.getRegistrationNo());
                }
            }
        }
        return regNos ;
    }

    public List<Integer> getSlotNoFromColor(String color) {
        List<Integer> regNos = new ArrayList<>();
        List<Slot> occupiedSlots = getOccupiedSlots();
        for (Slot curSlot : occupiedSlots) {
            if (!curSlot.isSlotFree()) {
                Car car = curSlot.getParkedCar();
                if (car.getColor().equals(color)) {
                    regNos.add(curSlot.getSlotNo());
                }
            }
        }
        return regNos ;
    }





}
