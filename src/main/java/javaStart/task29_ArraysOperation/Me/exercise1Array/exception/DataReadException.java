package javaStart.task29_ArraysOperation.Me.exercise1Array.exception;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
