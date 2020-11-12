package javaStart.task29_ArraysOperation.Me.exercise1.exception;

public class LengthNumberException extends RuntimeException {
    public LengthNumberException(String message) {
        System.err.println(message);
    }
}
