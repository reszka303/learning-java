package javaStart.task29_ArraysOperation.Me.exercise1Array.test;

import javaStart.task29_ArraysOperation.Me.exercise1Array.io.ConsolePrinter;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.DataReader;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Person;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.PersonDatabase;

import java.util.Arrays;

public class Test3RemoveNull {
    public static void main(String[] args) {
        PersonDatabase personDatabase = new PersonDatabase();
        ConsolePrinter printer = new ConsolePrinter();
        DataReader dataReader = new DataReader();

        Person[] persons = personDatabase.create();
        printer.print(persons);
        persons = personDatabase.removePerson();
//        System.out.println(Arrays.toString(persons));
        printer.print(persons);
    }
}
