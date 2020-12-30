package javaStart.task34_Queue.exercise2.exception;

public class NoSuchOptionException extends RuntimeException {
    public NoSuchOptionException(String message) {
        System.err.println(message);
    }
}
