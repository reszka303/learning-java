package javaStart.task36Collections.exercise1.extended;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
