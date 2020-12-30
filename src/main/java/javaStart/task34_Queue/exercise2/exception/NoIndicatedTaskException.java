package javaStart.task34_Queue.exercise2.exception;

public class NoIndicatedTaskException extends RuntimeException {
    public NoIndicatedTaskException(String message) {
        System.err.println(message);
    }
}
