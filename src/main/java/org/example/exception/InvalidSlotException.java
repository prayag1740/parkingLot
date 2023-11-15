package org.example.exception;

public class InvalidSlotException extends RuntimeException{

    public InvalidSlotException() {
        super("Invalid slot provided , Please try again");
    }

}
