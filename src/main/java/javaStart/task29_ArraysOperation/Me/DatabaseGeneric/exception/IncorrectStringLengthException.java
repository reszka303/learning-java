package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class IncorrectStringLengthException extends RuntimeException {
    public IncorrectStringLengthException(String message) {
        System.err.println(message);
    }
}
