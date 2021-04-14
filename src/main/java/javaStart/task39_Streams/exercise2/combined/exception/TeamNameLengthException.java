package javaStart.task39_Streams.exercise2.combined.exception;

public class TeamNameLengthException extends RuntimeException {
    public TeamNameLengthException(String message) {
        System.err.println(message);
    }
}
