package javaStart.task29_ArraysOperation.Me.exercise1.io;

import javaStart.task29_ArraysOperation.Me.exercise1.exception.PersonNotFoundException;
import javaStart.task29_ArraysOperation.Me.exercise1.model.Person;

import java.util.List;

public class ConsolePrinter {

    public void printPerson(List<Person> people) {
        for (Person person : people) {
            printLine(person.toString());
        }
        if (people.isEmpty()) {
            throw new PersonNotFoundException("There is no person");
        }
    }
    public void printLine(String text) {
        System.out.println(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
