package javaStart.task29_ArraysOperation.Me.exercise1Array.exception;

public class NumberNotFoundException extends RuntimeException {
    public NumberNotFoundException(String message) {
        System.err.println(message);
    }
}
