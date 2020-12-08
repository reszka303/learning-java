package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class LetterNotFoundException extends RuntimeException {
    public LetterNotFoundException(String message) {
        System.err.println(message);
    }
}
