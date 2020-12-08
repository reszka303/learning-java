package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class IncorrectIdLengthException extends RuntimeException {
    public IncorrectIdLengthException(String message) {
        System.err.println(message);
    }
}
