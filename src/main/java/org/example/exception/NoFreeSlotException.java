package org.example.exception;

public class NoFreeSlotException extends RuntimeException {
    public NoFreeSlotException() {
        super("No Free slots available");
    }
}
