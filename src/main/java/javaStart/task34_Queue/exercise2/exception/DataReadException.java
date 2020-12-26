package javaStart.task34_Queue.exercise2.exception;

public class DataReadException extends RuntimeException {
    public DataReadException(String message) {
        System.err.println(message);
    }
}
