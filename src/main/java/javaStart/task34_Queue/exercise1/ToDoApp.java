package javaStart.task34_Queue.exercise1;

import java.util.*;

public class ToDoApp {
    private static final Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        TaskManager.controlLoop();
    }

    private static class TaskManager {
        private static final Queue<Task> taskQueue = new PriorityQueue<>();

        static void controlLoop() {
            Option option;
            do {
                printOption();
                option = getOption();
                switch (option) {
                    case EXIT:
                        printLine("Exit program");
                        break;
                    case ADD:
                        taskQueue.offer(readAndCreateTask());
                        printLine("Task has been added to the queue");
                        break;
                    case TAKE:
                        takeTask();
                        break;
                }

            } while (option != Option.EXIT);
        }

        private static void takeTask() {
            if (taskQueue.isEmpty())
                printLine("There is no task");
            else {
                Task nextTask = taskQueue.poll();
                printLine("Task to do");
                printLine("" + nextTask);
            }
        }

        private static Task readAndCreateTask() {

            printLine("Enter the name of task");
            String name = input.nextLine();
            printLine("Enter the description of task");
            String description = input.nextLine();
            printLine("Enter priority");
            printPriority();
            Task.Priority priority = Task.Priority.valueOf(getPriority());
            return new Task(name, description, priority);
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
        for (Task.Priority priority : Task.Priority.values()) {
            if (value.equals(priority.name().toUpperCase())) {
                return value;
            }
        }
        throw new NoSuchPriorityException("Enter the priority value, try again");
    }

    private static void printPriority() {
        int counter = 0;
        for (Task.Priority priority : Task.Priority.values()) {
            counter++;
            if (Task.Priority.values().length == counter)
                printLine("" + priority);
            else {
                printNoLine(priority + ",");
            }
        }
    }

    private static class Task implements Comparable<Task> {
        private final String name;
        private final String description;
        private final Priority priority;

        public Task(String name, String description, Priority priority) {
            this.name = name;
            this.description = description;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Priority getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return name + " " + description + " " + priority;
        }

        @Override
        public int compareTo(Task task) {
            return priority.compareTo(task.priority);
        }


        private enum Priority {
            HIGH, MODERATE, LOW
        }
    }

    private static void printOption() {
        for (Option option : Option.values()) {
            printLine(option.toString());
        }
    }

    private static Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk) {
            try {
                option = Option.createFromInt(getInt());
                optionOk = true;
            } catch (InputMismatchException e) {
                printLineError("Enter a digit, try again");
            } catch (ArrayIndexOutOfBoundsException | NoSuchOptionException e) {
                e.getMessage();
            }
        }
        return option;
    }

    private enum Option {
        EXIT(0, "Exit"),
        ADD(1, "Add a new task"),
        TAKE(2, "Take the task");

        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        static Option createFromInt(int option) {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("There is no option: " + option);
            }
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }
    }

    private static class NoSuchOptionException extends RuntimeException {
        public NoSuchOptionException(String message) {
            printLineError(message);
        }
    }

    private static class NoSuchPriorityException extends RuntimeException {
        public NoSuchPriorityException(String message) {
            printLineError(message);
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

    private static int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }
}