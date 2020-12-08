package javaStart.task29_ArraysOperation.Me.exercise1.app;

import javaStart.task29_ArraysOperation.Me.exercise1.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1.exception.NoIndicatedPersonException;
import javaStart.task29_ArraysOperation.Me.exercise1.exception.NoSuchOptionException;
import javaStart.task29_ArraysOperation.Me.exercise1.exception.PersonNotFoundException;
import javaStart.task29_ArraysOperation.Me.exercise1.model.PersonDatabase;
import javaStart.task29_ArraysOperation.Me.exercise1.io.ConsolePrinter;
import javaStart.task29_ArraysOperation.Me.exercise1.io.DataReader;
import javaStart.task29_ArraysOperation.Me.exercise1.model.Person;

import java.util.*;

public class PersonControl {
    DataReader dataReader = new DataReader();
    PersonDatabase personDatabase = new PersonDatabase();
    ConsolePrinter printer = new ConsolePrinter();

    void run() {
        controlLoop();
    }

    private void controlLoop() {
        Option option;

        do {
            printOption();
            option = getOption();

            switch (option) {
                case ADD_PERSON:
                    addPerson();
                    break;
                case REMOVE_PERSON:
                    removePerson();
                    break;
                case PRINT_PERSONS:
                    printPerson();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("There is no option, try again");
            }
        } while (option!= Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk) {
            try {
                option = Option.writeInt(dataReader.getInt());
                optionOk = true;
            }
            catch (InputMismatchException e) {
                printer.printLineError("You entered a value that " +
                        "is not a number, please enter again:");
            } catch (ArrayIndexOutOfBoundsException e) {
                printer.printLineError( "You entered the number " +
                        "which is not an option, try again");
            }
        }
        return option;
    }

    private void addPerson() {
        try {
            Person person = dataReader.createPerson();
            personDatabase.add(person);
        } catch (NullPointerException e) {
            printer.printLineError(e.getMessage());
        } catch (DuplicateException e) {
            e.getMessage();
        }
    }

    private void removePerson() {
        try {
            Person person = dataReader.removePerson();
            if (personDatabase.remove(person)) {
                printer.printLine("The person has been deleted from a database");
            } else
                throw new NoIndicatedPersonException("No indicated person");
        } catch (InputMismatchException e) {
            printer.printLine("The new person could not be saved in the database");
        } catch (NoIndicatedPersonException e) {
            e.getMessage();
        }
    }

    private void printPerson() {
        try {
            List<Person> people = personDatabase.getPeople();
            printer.printPerson(people);
        } catch (PersonNotFoundException e) {
            e.getMessage();
        }
    }

    private void exit() {
        printer.printLine("End of program");
        dataReader.close();
    }

    private void printOption() {
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private enum Option {
        EXIT(0, "Exit"),
        ADD_PERSON(1, "Add person"),
        REMOVE_PERSON(2, "Remove person"),
        PRINT_PERSONS(3, "Print person");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option writeInt(int option) {
            if (option > Option.values().length) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                return Option.values()[option];
            }
        }
    }
}
