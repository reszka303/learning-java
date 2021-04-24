package javaStart.task29_ArraysOperation.Me.exercise1Array.io;

import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Person;

public class ConsolePrinter {
    public void print(Person[] persons) {
        for (Person person : persons) {
            printLine(person.toString());
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
