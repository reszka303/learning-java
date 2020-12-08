package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class IncorrectCharacterException extends RuntimeException {
    public IncorrectCharacterException(String message) {
        System.err.println(message);
    }
}
