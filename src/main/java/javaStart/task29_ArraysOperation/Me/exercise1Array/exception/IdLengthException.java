package javaStart.task29_ArraysOperation.Me.exercise1Array.exception;

public class IdLengthException extends RuntimeException {
    public IdLengthException(String message) {
        System.err.println(message);
    }
}
