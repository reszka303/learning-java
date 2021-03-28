package javaStart.task39_Streams.exercise2.combined.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String message) {
        System.err.println(message);
    }
}
