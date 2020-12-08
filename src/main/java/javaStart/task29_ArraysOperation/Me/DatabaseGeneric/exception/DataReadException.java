package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
