package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.app;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.CheckDuplicateException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.DataReadException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.NoIndicatedItemException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.NoSuchOptionException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io.ConsolePrinter;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io.DataReader;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io.file.FileManager;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io.file.SerializableFileManager;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.Item;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.ItemDatabase;

import java.util.InputMismatchException;
import java.util.List;

public class ItemControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private ItemDatabase itemDatabase;

    private FileManager fileManager;

    public ItemControl() {
       fileManager = new SerializableFileManager();
       try {
           itemDatabase = fileManager.read();
           printer.printLine("Data file has been read");
       } catch (DataReadException e) {
           e.getMessage();
           printer.printLine("Initiated a new database");
           itemDatabase = new ItemDatabase();
       }

    }

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
                case PRINT_PERSON:
                    printPersons();
                    break;
                case ADD_CAR:
                    addCar();
                    break;
                case REMOVE_CAR:
                    removeCar();
                    break;
                case PRINT_CAR:
                    printCar();
                    break;
                case EXIT:
                    exit();
                    break;
            }

        } while (option != Option.EXIT);
    }

    private void addPerson() {
        printer.printLine("Enter data of a person");
        Item owner = dataReader.createPerson();
        try {
            itemDatabase.addPerson(owner);
        } catch (CheckDuplicateException e) {
            e.getMessage();
        }
    }

    private void removePerson() {
        printer.printLine("Enter id of a person to remove");
        try {
            Item owner = dataReader.removePerson();
            if (itemDatabase.removePerson(owner)) {
                printer.printLine("Person has been removed from a database");
            }
        } catch (NoIndicatedItemException e) {
            e.getMessage();
        } catch (InputMismatchException e) {
            printer.printLineError("The person couldn't be removed");
        }
    }

    private void printPersons() {
        List<Item> person = itemDatabase.getPerson();
        printer.printPerson(person);
    }

    private void addCar() {
        printer.printLine("Enter data of a car");
        Item car = dataReader.createCar();
        try {
            itemDatabase.addCar(car);
        } catch (CheckDuplicateException e) {
            e.getMessage();
        }
    }

    private void removeCar() {
        Item item = dataReader.removeCar();
        try {
            if (itemDatabase.removeCar(item)) {
                printer.printLine("The car has been removed from a database");
            }
        } catch (NoIndicatedItemException e) {
            e.getMessage();
        } catch (InputMismatchException e) {
            printer.printLineError("The person couldn't be removed");
        }
    }

    private void printCar() {
        List<Item> cars = itemDatabase.getCars();
        printer.printCar(cars);
    }

    private void exit() {
        try {
            fileManager.write(itemDatabase);
            printer.printLine("Writing data into file has been finished successfully");
        } catch (DataReadException e) {
            e.getMessage();
        }
        dataReader.close();
        printer.printLine("End of program");
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("Enter a digit only, try again");
            }
        }
        return option;
    }

    private void printOption() {
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private enum Option {
        EXIT(0, "EXIT"),
        ADD_PERSON(1, "ADD PERSON"),
        REMOVE_PERSON(2, "REMOVE PERSON"),
        PRINT_PERSON(3, "PRINT PERSON"),
        ADD_CAR(4, "ADD CAR"),
        REMOVE_CAR(5, "REMOVE CAR"),
        PRINT_CAR(6, "PRINT CAR");

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

        static Option createFromInt(int option) {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("No such option: " + option);
            }
        }
    }
}
