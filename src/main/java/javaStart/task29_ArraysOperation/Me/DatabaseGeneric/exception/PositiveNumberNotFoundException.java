package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class PositiveNumberNotFoundException extends RuntimeException {
    public PositiveNumberNotFoundException(String message) {
        System.err.println(message);
    }
}
