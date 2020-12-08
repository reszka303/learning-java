package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class IncorrectVinLengthException extends RuntimeException {
    public IncorrectVinLengthException(String message) {
        System.err.println(message);
    }
}
