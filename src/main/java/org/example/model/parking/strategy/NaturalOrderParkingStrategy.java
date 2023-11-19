package org.example.model.parking.strategy;

import org.example.exception.NoFreeSlotException;

import java.util.TreeSet;

public class NaturalOrderParkingStrategy implements ParkingStrategy {

    TreeSet<Integer> slotTreeSet ;

    public NaturalOrderParkingStrategy() {
        this.slotTreeSet = new TreeSet<Integer>();
    }

    @Override
    public void addSlot(Integer slotNo) {
        this.slotTreeSet.add(slotNo);
    }

    @Override
    public void removeSlot(Integer slotNo) {
        this.slotTreeSet.remove(slotNo);
    }

    @Override
    public Integer getNextSlot() {
        if (this.slotTreeSet.isEmpty()) {
            throw new NoFreeSlotException();
        }
        return this.slotTreeSet.first();
    }
}
