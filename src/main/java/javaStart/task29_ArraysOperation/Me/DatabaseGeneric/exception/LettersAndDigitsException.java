package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class LettersAndDigitsException extends RuntimeException {
    public LettersAndDigitsException(String message) {
        System.err.println(message);
    }
}
