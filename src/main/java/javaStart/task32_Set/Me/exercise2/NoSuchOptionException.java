package javaStart.task32_Set.Me.exercise2;

public class NoSuchOptionException extends RuntimeException {
    public NoSuchOptionException(String message) {
        System.err.println(message);
    }
}
