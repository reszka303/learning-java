package javaStart.task22_Exceptions.exercise1.JS;

class UnknownOperatorException extends RuntimeException {
    public UnknownOperatorException(String message) {
        super(message);
    }
}