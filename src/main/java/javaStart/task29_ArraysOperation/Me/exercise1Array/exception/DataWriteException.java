package javaStart.task29_ArraysOperation.Me.exercise1Array.exception;

public class DataWriteException extends RuntimeException {
    public DataWriteException(String message) {
        System.err.println(message);
    }
}
