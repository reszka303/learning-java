package javaStart.task39_Streams.exercise2.combined.exception;

public class TeamDuplicateException extends RuntimeException {
    public TeamDuplicateException(String message) {
        System.err.println(message);
    }
}
