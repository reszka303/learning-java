package javaStart.task32_Set.Me.exercise2;

public class PositiveNumberNotFoundException extends RuntimeException {
    public PositiveNumberNotFoundException(String message) {
        System.err.println(message);
    }
}
