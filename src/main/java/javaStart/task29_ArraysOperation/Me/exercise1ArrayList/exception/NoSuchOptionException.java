package javaStart.task29_ArraysOperation.Me.exercise1ArrayList.exception;

public class NoSuchOptionException extends RuntimeException {
    public NoSuchOptionException(String message) {
        System.err.println(message);
    }
}
