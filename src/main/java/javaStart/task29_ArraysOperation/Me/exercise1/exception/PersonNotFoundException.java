package javaStart.task29_ArraysOperation.Me.exercise1.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        System.err.println(message);
    }
}
