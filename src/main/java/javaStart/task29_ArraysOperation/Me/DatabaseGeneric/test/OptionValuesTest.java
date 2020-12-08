package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.NoSuchOptionException;

public class OptionValuesTest {
    public static void main(String[] args) {
        printOption();
        printLine("");
        int option = 2;
        printLine("Entered index number: " + option + " of Option array: ");
        printLine("" + Option.createFromInt(option));
    }

    private enum Option {
        EXIT(0, "EXIT"),
        ADD_OWNER(1, "ADD OWNER"),
        REMOVE_OWNER(2, "REMOVE OWNER"),
        PRINT_OWNER(3, "PRINT OWNER");

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

        private static Option createFromInt(int option) {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("No such option: " + option);
            }
        }
    }

    private static void printOption() {
        for (Option value: Option.values()) {
            printLine(value.toString());
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}
