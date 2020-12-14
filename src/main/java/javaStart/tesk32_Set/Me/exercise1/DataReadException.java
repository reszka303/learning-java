package javaStart.tesk32_Set.Me.exercise1;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
