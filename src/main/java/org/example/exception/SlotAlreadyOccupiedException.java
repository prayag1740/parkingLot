package org.example.exception;

public class SlotAlreadyOccupiedException extends RuntimeException {
    public SlotAlreadyOccupiedException() {
        super("The slot is already occupied");
    }

}
