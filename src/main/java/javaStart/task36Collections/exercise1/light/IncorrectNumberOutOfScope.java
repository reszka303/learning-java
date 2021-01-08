package javaStart.task36Collections.exercise1.light;

public class IncorrectNumberOutOfScope extends RuntimeException {
    public IncorrectNumberOutOfScope(String message) {
        System.err.println(message);
    }
}
