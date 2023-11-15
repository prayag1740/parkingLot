package org.example.exception;

public class SlotAlreadyFreeException extends RuntimeException {
    public SlotAlreadyFreeException(){
        super("Slot is already free");
    }
}
