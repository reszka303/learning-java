package javaStart.task29_ArraysOperation.Me.exercise1Array.io;

import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Car;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Person;

import java.util.Arrays;

public class ConsolePrinter {
//    public <T> void print(T[] t) {
//      printLine(Arrays.toString(t));
//        if (t.length == 0) {
//            printLine("The database is empty");
//        }
//    }

//    public void print(Car[] cars) {
//        printLine(Arrays.toString(cars));
//        if (cars.length == 0) {
//            printLine("The database is empty");
//        }
//    }

//    public void print(Car[] cars) {
//        for (Car car : cars) {
//            printLine(car.toString());
//        }
//        if (cars.length == 0) {
//            printLine("The database is empty");
//        }
//    }

    public <T> void print(T[] t) {
        for (T object : t) {
            printLine(object.toString());
        }
        if (t.length == 0) {
            printLine("The database is empty");
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
