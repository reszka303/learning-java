package javaStart.task29_ArraysOperation.Me.Database;

public class DataWriteException extends RuntimeException {
    public DataWriteException(String message) {
        System.err.println(message);
    }
}
