package javaStart.task29_ArraysOperation.Me.exercise1ArrayList.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        System.err.println(message);
    }
}
