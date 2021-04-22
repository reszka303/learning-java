package javaStart.task29_ArraysOperation.Me.exercise1ArrayList.io;

import javaStart.task29_ArraysOperation.Me.exercise1ArrayList.exception.LengthNumberException;
import javaStart.task29_ArraysOperation.Me.exercise1ArrayList.exception.PositiveNumberNotFoundException;
import javaStart.task29_ArraysOperation.Me.exercise1ArrayList.model.Person;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner input = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();

    public Person createPerson() {
        printer.printLine("Give a first name:");
        String firstName = input.nextLine();
        printer.printLine("Give a second name");
        String secondName = input.nextLine();
        printer.printLine("Give an id:");
        BigInteger id = writeId();

        return new Person(firstName, secondName, id);
    }

    public Person removePerson() {
        printer.printLine("Give an id:");
        BigInteger id = writeId();

        return new Person(id);
    }

    private BigInteger writeId() {
        BigInteger id = new BigInteger("-1");
        boolean idOk = false;

        while (!idOk) {
            while (id.signum() < 0 || id.toString().length() != 11) {
                try {
                    id = input.nextBigInteger();
                    if (id.signum() < 0) {
                        throw new PositiveNumberNotFoundException("The number must be positive, try again");
                    } else if (id.toString().length() != 11) {
                        throw new LengthNumberException("The number must be 11 digits, try again");
                    } else {
                        idOk = true;
                    }
                } catch (PositiveNumberNotFoundException e) {
                    e.getMessage();
                } catch (LengthNumberException e) {
                    e.getMessage();
                } catch (InputMismatchException e) {
                    printer.printLineError("You didn't enter number, try again");
                } finally {
                    clearBuffer();
                }
            }
        }
        return id;
    }

    public void clearBuffer() {
        input.nextLine();
    }

    public int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }

    public void close() {
        input.close();
    }
}
