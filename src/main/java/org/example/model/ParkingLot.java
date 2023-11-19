package org.example.model;

import org.example.exception.InvalidSlotException;
import org.example.exception.ParkingLotException;
import org.example.exception.SlotAlreadyFreeException;
import org.example.exception.SlotAlreadyOccupiedException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final int MAX_CAPACITY = 100000 ;
    private final int capacity ;
    private Map<Integer, Slot> slots ;

    public ParkingLot(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new ParkingLotException();
        }
        this.capacity = capacity ;
        this.slots = new HashMap<>() ;
        for (int i=1 ; i<=capacity ; i++) {
            this.slots.put(i, new Slot(i));
        }
    }

    public Map<Integer, Slot> getSlots() {
        return slots;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets or create a slot in allSlot map for a given slot number
     * @param slotNo slot number
     * @return slot object for a given slotNo
     */
    public Slot getSlot(Integer slotNo) {
        if (slotNo > MAX_CAPACITY || slotNo <= 0) {
            throw new InvalidSlotException();
        }
        Map<Integer, Slot> allSlots = getSlots() ;
        return allSlots.get(slotNo);
    }

    /**
     * Parks a car to the slot
     * @param car Car to be parked
     * @param slotNo Slot no where car would be parked
     * @return slot where car is parked
     */
    public Slot park(Car car, Integer slotNo) {
        Slot currentSlot = getSlot(slotNo);
        if (!currentSlot.isSlotFree()) {
            throw new SlotAlreadyOccupiedException();
        }
        currentSlot.assignCar(car);
        return currentSlot;
    }

    /**
     *
     * @param slotNo against which slot need to be free
     * @return free slot
     */
    public Slot makeSlotFree(Integer slotNo) {
        Slot currentSlot = getSlot(slotNo);
        if (currentSlot.isSlotFree()) {
            throw new SlotAlreadyFreeException() ;
        }
        currentSlot.freeSlot();
        return currentSlot ;
    }




}
