package org.example.model;

public class Slot {
    private Car parkedCar ;
    private Integer slotNo ;

    public Slot( Integer slotNo) {
        this.slotNo = slotNo ;
    }

    public Integer getSlotNo() {
        return slotNo;
    }

    public void assignCar(Car parkedCar) {
        this.parkedCar = parkedCar ;
    }

    public void freeSlot() {
        this.parkedCar = null ;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public boolean isSlotFree() {
        return this.parkedCar == null ;
    }

}
