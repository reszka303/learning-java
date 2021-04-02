package javaStart.task39_Streams.exercise2.combined.exception;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
