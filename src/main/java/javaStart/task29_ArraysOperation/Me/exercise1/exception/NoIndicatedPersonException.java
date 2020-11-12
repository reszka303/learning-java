package javaStart.task29_ArraysOperation.Me.exercise1.exception;

public class NoIndicatedPersonException extends RuntimeException {
    public NoIndicatedPersonException(String message) {
        System.err.println(message);
    }
}
