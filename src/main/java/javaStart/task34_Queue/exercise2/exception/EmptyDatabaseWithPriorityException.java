package javaStart.task34_Queue.exercise2.exception;

public class EmptyDatabaseWithPriorityException extends RuntimeException {
    public EmptyDatabaseWithPriorityException(String message) {
        System.err.println(message);
    }
}
