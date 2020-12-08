package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

public class NoIndicatedItemException extends RuntimeException {
    public NoIndicatedItemException(String message) {
        System.err.println(message);
    }
}
