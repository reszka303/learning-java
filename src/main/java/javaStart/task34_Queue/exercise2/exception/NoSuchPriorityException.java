package javaStart.task34_Queue.exercise2.exception;

public class NoSuchPriorityException extends RuntimeException {
    public NoSuchPriorityException(String message) {
        System.err.println(message);
    }
}
