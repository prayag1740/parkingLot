package org.example.exception;

public class InvalidFileModeException extends RuntimeException {

    public InvalidFileModeException() {
        super("Invalid file mode input");
    }
}
