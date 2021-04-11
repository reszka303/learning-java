package javaStart.task39_Streams.exercise2.combined.exception;

public class NoSuchOptionException extends RuntimeException {
    public NoSuchOptionException(String message) {
        System.err.println(message);
    }
}
