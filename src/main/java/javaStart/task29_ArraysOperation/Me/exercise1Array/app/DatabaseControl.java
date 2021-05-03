package javaStart.task29_ArraysOperation.Me.exercise1Array.app;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.NumberNotFoundException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.NoSuchOptionException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.ConsolePrinter;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.DataReader;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Car;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.CarDatabase;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Person;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.PersonDatabase;

import java.util.InputMismatchException;

public class DatabaseControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private PersonDatabase personDatabase = new PersonDatabase();
    private CarDatabase carDatabase = new CarDatabase();
    private Car car;
    private static final int EXIT = 0;
    private static final int ADD_PERSON = 1;
    private static final int REMOVE_PERSON = 2;
    private static final int PRINT_PERSONS = 3;
    private static final int ADD_CAR = 4;
    private static final int REMOVE_CAR = 5;
    private static final int PRINT_CARS = 6;
    private final int initialCapacity = 7;
    private Option[] options = new Option[initialCapacity];

    void run() {
        controlLoop();
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

    private void exit() {
        printer.printLine("Exit program, bye");
        dataReader.close();
    }

    private void addPerson() {
        try {
            Person person = dataReader.createPerson();
            int capacity = personDatabase.getPersons().length;
            Person[] persons = personDatabase.add(person);
            int resize = persons.length;
            if (resize > capacity) {
                printer.printLine("You added a new person to the database");
            }
        } catch (DuplicateException e) {
            e.getMessage();
        }
    }

    private void removePerson() {
        int id = dataReader.getNumberToRemove();
        int capacity = personDatabase.getPersons().length;
        try {
            Person[] persons = personDatabase.remove(id);
            int resize = persons.length;
            if (resize < capacity) {
                printer.printLine("You removed the person from the database");
            }
        } catch (NumberNotFoundException e) {
            e.getMessage();
        }

    }

    private void printPersons() {
        Person[] persons = personDatabase.getPersons();
        printer.print(persons);
    }

    private void addCar() {
        try {
            Car car = dataReader.createCar();
//            int capacity = car.getCars().length;
            int capacity = carDatabase.getCars().length;
//            Car[] cars = car.add(car);
            Car[] cars = carDatabase.add(car);
            int resize = cars.length;
            if (resize > capacity) {
                printer.printLine("You added a new car to the database");
            }
        } catch (DuplicateException e) {
            e.getMessage();
        }
    }

    private void removeCar() {
        try {
            int vin = dataReader.getNumberToRemove();
            int capacity = carDatabase.getCars().length;
//            Car[] cars = car.getCars();
            Car[] cars = carDatabase.remove(vin);
//            Car[] cars = car.remove(vin);
            int resize = cars.length;
            if (resize < capacity) {
                printer.printLine("You removed the car from the database");
            }
        } catch (NumberNotFoundException e) {
            e.getMessage();
        }
    }

    private void printCars() {
//        Car[] cars = car.getCars();
        Car[] cars = carDatabase.getCars();
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
