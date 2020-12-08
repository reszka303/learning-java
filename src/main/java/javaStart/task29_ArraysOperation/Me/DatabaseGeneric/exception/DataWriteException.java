package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class DataWriteException extends RuntimeException {
    public DataWriteException(String message) {
        System.err.println(message);
    }
}
