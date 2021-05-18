package javaStart.task29_ArraysOperation.Me.exercise1Array.app;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.*;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.ConsolePrinter;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.DataReader;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.file.CsvFileManager;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.file.FileManager;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.*;

import java.util.InputMismatchException;

public class DatabaseControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private DatabaseManager databaseManager;
    private FileManager fileManager = new CsvFileManager();
    private static final int EXIT = 0;
    private static final int ADD_PERSON = 1;
    private static final int REMOVE_PERSON = 2;
    private static final int PRINT_PERSONS = 3;
    private static final int ADD_CAR = 4;
    private static final int REMOVE_CAR = 5;
    private static final int PRINT_CARS = 6;
    private final int initialCapacity = 7;
    private Option[] options = new Option[initialCapacity];

    public DatabaseControl() {
        readFile();
    }

    void run() {
        try {
            controlLoop();
        } catch (DataReadException e) {
            printer.printLine(e.getMessage());
        }
    }

    private void controlLoop() {
        Option option;
        do {
            options = create();
            printOption();
            option = getOption();
            switch (option.getValue()) {
                case EXIT:
                    exit();
                    break;
                case ADD_PERSON:
                    addPerson();
                    break;
                case REMOVE_PERSON:
                    removePerson();
                    break;
                case PRINT_PERSONS:
                    printPersons();
                    break;
                case ADD_CAR:
                    addCar();
                    break;
                case REMOVE_CAR:
                    removeCar();
                    break;
                case PRINT_CARS:
                    printCars();
                    break;
            }
        } while (option.getValue() != EXIT);
    }

    private void readFile() {
        try {
            databaseManager = fileManager.read();
            printer.printLine("Data from the file has been read successfully");
        } catch (DataReadException e) {
            e.getMessage();
            printer.printLine("The new database has been initiated");
            databaseManager = new DatabaseManager();
        }
    }

    private void exit() {
        try {
            fileManager.write(databaseManager);
            printer.printLine("Write data into file has been successful");
        } catch (DataWriteException e) {
            e.getMessage();
        }
        dataReader.close();
        printer.printLine("Exit program, bye");
    }

    private void addPerson() {
        try {
            Person person = dataReader.createPerson();
            int capacity = databaseManager.getPersonDatabase().getPersons().length;
            Person[] persons = databaseManager.getPersonDatabase().add(person);
            int resize = persons.length;
            if (resize > capacity) {
                printer.printLine("You added a new person to the database");
            }
        } catch (DuplicateException e) {
            e.getMessage();
        }
    }

    private void removePerson() {
        try {
            int id = dataReader.getNumberToRemove();
            int capacity = databaseManager.getPersonDatabase().getPersons().length;
            Person[] persons = databaseManager.getPersonDatabase().remove(id);
            int resize = persons.length;
            if (resize < capacity) {
                printer.printLine("You removed the person from the database");
            }
        } catch (NumberNotFoundException e) {
            e.getMessage();
        }

    }

    private void printPersons() {
        Person[] persons = databaseManager.getPersonDatabase().getPersons();
        printer.print(persons);
    }

    private void addCar() {
        Car car = dataReader.createCar();
        int capacity = databaseManager.getCarDatabase().getCars().length;
        try {
            Car[] cars = databaseManager.getCarDatabase().add(car);
            int resize = cars.length;
            if (resize > capacity) {
                printer.printLine("You added a new car to the database");
            }
        } catch (DuplicateException e) {
            e.getMessage();
        }
    }

    private void removeCar() {
        int vin = dataReader.getNumberToRemove();
        int capacity = databaseManager.getCarDatabase().getCars().length;
        try {
            Car[] cars = databaseManager.getCarDatabase().remove(vin);
            int resize = cars.length;
            if (resize < capacity) {
                printer.printLine("You removed the car from the database");
            }
        } catch (NumberNotFoundException e) {
            e.getMessage();
        }
    }

    private void printCars() {
        Car[] cars = databaseManager.getCarDatabase().getCars();
        printer.print(cars);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = createFromInt(dataReader.getIntNoBuffer());
                optionOk = true;
            } catch (ArrayIndexOutOfBoundsException | NoSuchOptionException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                printer.printLineError("Enter a digit, try again");
            } finally {
                dataReader.clearBuffer();
            }
        }
        return option;
    }

    private Option createFromInt(int option) {
        try {
            return options[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("There is no option: " + option + ", try again");
        }
    }

    private void printOption() {
        for (Option option : options) {
            printer.printLine(option.toString());
        }
    }

    private Option[] create() {
        options[0] = new Option(0, "Exit");
        options[1] = new Option(1, "Add person");
        options[2] = new Option(2, "Remove person");
        options[3] = new Option(3, "Print persons");
        options[4] = new Option(4, "Add car");
        options[5] = new Option(5, "Remove car");
        options[6] = new Option(6, "Print cars");
        return options;
    }

    private class Option {
        private int value;
        private String description;

        public Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }
    }
}
