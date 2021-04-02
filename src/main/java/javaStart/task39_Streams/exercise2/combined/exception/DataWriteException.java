package javaStart.task39_Streams.exercise2.combined.exception;

public class DataWriteException extends RuntimeException {
    public DataWriteException(String message) {
        System.err.println(message);
    }
}
