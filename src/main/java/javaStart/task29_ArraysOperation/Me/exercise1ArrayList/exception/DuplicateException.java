package javaStart.task29_ArraysOperation.Me.exercise1ArrayList.exception;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        System.err.println(message);
    }
}
