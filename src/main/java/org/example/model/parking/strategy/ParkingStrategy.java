package org.example.model.parking.strategy;

public interface ParkingStrategy {

    public void addSlot(Integer slotNo);
    public void removeSlot(Integer slotNo);
    public Integer getNextSlot() ;

}
