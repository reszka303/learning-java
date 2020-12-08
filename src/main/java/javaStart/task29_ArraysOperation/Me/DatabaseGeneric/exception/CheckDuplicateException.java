package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io.ConsolePrinter;

public class CheckDuplicateException extends RuntimeException {
    private ConsolePrinter printer = new ConsolePrinter();

    public CheckDuplicateException(String message) {
        printer.printLineError(message);
    }
}
