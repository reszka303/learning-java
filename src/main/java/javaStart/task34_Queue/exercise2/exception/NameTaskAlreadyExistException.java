package javaStart.task34_Queue.exercise2.exception;

public class NameTaskAlreadyExistException extends RuntimeException {
    public NameTaskAlreadyExistException(String message) {
        System.err.println(message);
    }
}
