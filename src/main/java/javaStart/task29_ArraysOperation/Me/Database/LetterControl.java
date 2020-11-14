package javaStart.task29_ArraysOperation.Me.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class LetterControl {
    private DataReader dataReader = new DataReader();
    private ConsolePrinter printer = new ConsolePrinter();
    private SerializableFileManager serializableFileManager = new SerializableFileManager();
    private LetterDatabase letterDatabase;

    public LetterControl() {
        try {
            letterDatabase = serializableFileManager.readData();
            printer.printLine("Data of file has been read");
        } catch (DataReadException e) {
            e.getMessage();
            printer.printLine("Initiated a new database");
            letterDatabase = new LetterDatabase();
        }

    }

    void run(){
        controlLoop();
    }

    void controlLoop() {
        Option option;

        do {
            printOption();
            option = getOption();

            switch (option) {
                case ADD:
                    add();
                    break;
                case PRINT:
                    printLetter();
                    break;
                case EXIT:
                    exit();
                    break;
            }
        } while (option != Option.EXIT);
    }

    private void add() {
        Letter letter = dataReader.createLetter();
        letterDatabase.add(letter);
    }

    private void exit() {
        try {
            serializableFileManager.writeData(letterDatabase);
            printer.printLine("Data record into a file has been succeeded");
        } catch (DataWriteException e) {
            e.getMessage();
        }
        dataReader.close();
        printer.printLine("The program has been ended");
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk){
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (InputMismatchException e) {
                printer.printLineError("Enter a number not letter");
            } catch (NoSuchOptionException e) {
                e.getMessage();
            }
        }
        return option;
    }

    private void printLetter() {
        List<Letter> letters = letterDatabase.getLetters();
        printer.printLetter(letters);
    }

    private void printOption() {
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private enum Option {
        EXIT(0, "EXIT"),
        ADD(1, "ADD"),
        PRINT(2, "PRINT");

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
                throw new NoSuchOptionException("There is no option like" + option);
            }
        }
    }
}
