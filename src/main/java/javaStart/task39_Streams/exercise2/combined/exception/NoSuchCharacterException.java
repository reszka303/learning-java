package javaStart.task39_Streams.exercise2.combined.exception;

public class NoSuchCharacterException extends RuntimeException {
    public NoSuchCharacterException(String message) {
        System.err.println(message);
    }
}
