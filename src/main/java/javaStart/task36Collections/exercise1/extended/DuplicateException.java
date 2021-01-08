package javaStart.task36Collections.exercise1.extended;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        System.err.println(message);
    }
}
