package javaStart.task29_ArraysOperation.Me.exercise1.exception;

public class PositiveNumberNotFoundException extends RuntimeException {
    public PositiveNumberNotFoundException(String message) {
        System.err.println(message);
    }
}
