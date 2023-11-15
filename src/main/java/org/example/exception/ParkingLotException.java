package org.example.exception;

public class ParkingLotException extends RuntimeException {

    public ParkingLotException() {
        super("Invalid Capacity given for parking lot") ;
    }

}
