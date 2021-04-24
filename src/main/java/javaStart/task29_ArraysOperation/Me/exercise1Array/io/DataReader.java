package javaStart.task29_ArraysOperation.Me.exercise1Array.io;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.IdLengthException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private ConsolePrinter printer = new ConsolePrinter();
    private Scanner input = new Scanner(System.in);

    public Person create() {
        printer.printLine("Enter a first name");
        String firstName = input.nextLine();
        printer.printLine("Enter a second name");
        String secondName = input.nextLine();
        printer.printLine("Enter an id");
        int id = getId();
        return new Person(firstName, secondName, id);
    }

    public int getIdToRemove() {
        printer.printLine("Enter an id to remove a person");
        return getId();
    }

    private int getId() {
        boolean idOk = false;
        int id = 0;
        while (!idOk) {
            try {
                id = input.nextInt();
                id = checkLength(id);
                idOk = true;
            } catch (InputMismatchException e) {
                printer.printLineError("Enter digit, try again");
            } catch (IdLengthException e) {
                e.getMessage();
            } finally {
                clearBuffer();
            }
        }
        return id;
    }

    private int checkLength(int id) {
        int length = String.valueOf(id).length();
        if (length != 3) {
            throw new IdLengthException("Id must be 3 digits, try again");
        }
        return id;
    }

    private void clearBuffer() {
        input.nextLine();
    }

    private int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }
}
