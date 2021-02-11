package javaStart.task40_CollectionProcessing.exercise1;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
