package javaStart.task34_Queue.Test;

import java.util.Arrays;
import java.util.Scanner;


public class TestEnum {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        printLine("Podaj wartość:");
        String priorities = Arrays.toString(Priority.values());
        printLine(priorities);


        String value = input.nextLine().toUpperCase();
        String priority = null;

        for (int i = 0; i < Priority.values().length; i++) {
            if (value.equals(Priority.values()[i])) {
                priority = value;
            } else {
                printLineError("NoSuchPriorityException");
            }
        }
        printLine("Wybrana wartość to: " + priority);
    }


    private static class NoSuchPriorityException extends RuntimeException {
        public NoSuchPriorityException(String message) {
            printLineError(message);
        }
    }

    private enum Priority {
        HIGH, MODERATE, LOW;

        Priority(String description) {
            this.description = description;
        }

        private String description;

        Priority() {

        }

        @Override
        public String toString() {
            return "Priority{" +
                    "description='" + description + '\'' +
                    '}';
        }

        private static String getPriority() {
            boolean priorityOk = false;
            String priority = null;

            while (!priorityOk) {
                try {
                    priority = Priority.createFromString();
                    priorityOk = true;
                } catch (IllegalArgumentException | NoSuchPriorityException e) {
                    e.getMessage();
                }
            }
            return priority;
        }

        private static String createFromString() {
            String priority = input.nextLine().toUpperCase();
            if (priority.equals(Priority.values().toString()))
                return priority;
            else {
                throw new NoSuchPriorityException("Enter the priority values, try again");
            }
        }
    }

    static String createFromStringValues(String value) {
        for (Priority priority : Priority.values())
            if (priority.toString().equals(value.toUpperCase())) {
                return value;
            }

        throw new NoSuchPriorityException("Enter the priority values, try again");
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }
}

