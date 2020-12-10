package javaStart.task30_ComparableComparator.Me.exercise2;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
