package javaStart.task34_Queue.exercise2.exception;

public class DataWriteException extends RuntimeException {
    public DataWriteException(String message) {
        System.err.println(message);
    }
}
