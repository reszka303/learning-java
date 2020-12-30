package javaStart.task34_Queue.exercise2.io;

import javaStart.task34_Queue.exercise2.exception.NoSuchPriorityException;
import javaStart.task34_Queue.exercise2.model.Task;

import java.util.Scanner;

public class DataReader {
    private Scanner input = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();

    public Task createTask() {

        printer.printLine("Enter a name of task");
        String name = input.nextLine();
        printer.printLine("Enter description of task");
        String description = input.nextLine();
        printer.printLine("Enter priority of task");
        Task.Priority priority = Task.Priority.valueOf(getPriority());

        return new Task(name, description, priority);
    }

    public Task removeTask() {
        printer.printLine("Enter the name of task");
        String name = input.nextLine();

        return new Task(name);
    }

    private String getPriority() {
        boolean priorityOk = false;
        String priority = null;

        while (!priorityOk) {
            try {
                priority = getStringFromEnum();
                priorityOk = true;
            } catch (IllegalArgumentException | NoSuchPriorityException e) {
                e.getMessage();
            }
        }
        return priority;
    }

    private String getStringFromEnum() {
        String value = input.nextLine().toUpperCase();
        for (Task.Priority priority : Task.Priority.values() ) {
            if (value.equals(priority.toString())) {
                return value;
            }
        }
        throw new NoSuchPriorityException("There is no such priority " + value);
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
