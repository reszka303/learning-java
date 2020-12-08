package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.Item;

import java.util.List;

public class ConsolePrinter {
    public void printPerson(List<Item> person) {
        for (Item personElement : person ) {
            printLine(personElement.toStringPerson());
        }

        if (person.isEmpty()) {
            printLine("The database doesn't contain any person");
        }
    }

    public void printCar(List<Item> cars) {
        for (Item car : cars) {
            printLine(car.toStringCar());
        }

        if (cars.isEmpty()) {
            printLine("The database doesn't contain any car");
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
