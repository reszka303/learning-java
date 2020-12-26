package javaStart.task34_Queue.Test;

import java.util.Scanner;

public class TestEnumString {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Priority priority = run();
        printLine("You entered: " + priority.toString());
    }

    private static Priority run() {
        printPriority();
        printLine("Enter priority");
        String value = getPriority();
        Priority priority = Priority.valueOf(value);
        return priority;
    }

    private enum Priority {
        HIGH("High"),
        MODERATE("Moderate"),
        LOW("Low");

        private String status;

        Priority(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return status;
        }
    }

    private static String getPriority() {
        boolean priorityOk = false;
        String priority = null;

        while (!priorityOk) {
            try {
                priority = createFromString();
                priorityOk = true;
            } catch (IllegalArgumentException | NoSuchPriorityException e) {
                e.getMessage();
            }
        }
        return priority;
    }

    private static String createFromString() {
        String value = input.nextLine().toUpperCase();
        for (Priority priority : Priority.values()) {
            if (value.equals(priority.getStatus())) {
                return value;
            }
        }
        throw new NoSuchPriorityException("Enter the priority value, try again");
    }


    private static class NoSuchPriorityException extends RuntimeException {
        public NoSuchPriorityException(String message) {
            printLineError(message);
        }
    }

    private static void printPriority() {
        int counter = 0;
        for (Priority priority : Priority.values()) {
            counter++;
            if (Priority.values().length == counter)
                printLine("" + priority);
            else {
                printNoLine(priority + ",");
            }
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }

    private static void printNoLine(String text) {
        System.out.print(text);
    }
}
