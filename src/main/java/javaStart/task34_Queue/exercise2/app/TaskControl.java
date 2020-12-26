package javaStart.task34_Queue.exercise2.app;

import javaStart.task34_Queue.exercise2.exception.DataReadException;
import javaStart.task34_Queue.exercise2.exception.NoSuchPriorityException;
import javaStart.task34_Queue.exercise2.io.ConsolePrinter;
import javaStart.task34_Queue.exercise2.model.Task;
import javaStart.task34_Queue.exercise2.model.TaskManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class TaskControl {
    private Scanner input = new Scanner(System.in);
    private static String FILE_NAME = "D:\\INNE\\Programowanie\\Projects\\learning\\tasks.txt";
    private ConsolePrinter printer = new ConsolePrinter();

    void run() {
        try {
            Map<Task.Priority, TreeSet<Task>> priorityTaskEnumMap = readFile();
            Task.Priority priority = readPriorityFromUser();
            printCategoryStats(priorityTaskEnumMap, priority);
        } catch (DataReadException e) {
            e.getMessage();
        }
    }

    private void printCategoryStats(Map<Task.Priority, TreeSet<Task>> priorityTaskEnumMap, Task.Priority priority) {
        TreeSet<Task> taskTreeSet = priorityTaskEnumMap.get(priority);
        if (taskTreeSet == null) {
                printer.printLine("There is no task with given priority");
            } else {
                printer.printTask(taskTreeSet);
            }
    }

    private Map<Task.Priority, TreeSet<Task>> readFile() {
        try {
            return TaskManager.readFile(FILE_NAME);
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataReadException("Error read data " + FILE_NAME);
        }
    }

    private Task.Priority readPriorityFromUser() {
        printer.printLine("Enter the priority to display task with this priority");
        printer.printPriority();
        printer.printLine("");
        String value = getPriority();
        Task.Priority priority = Task.Priority.valueOf(value);
        return priority;
    }

    private String getPriority() {
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

    private String createFromString() {
        String value = input.nextLine().toUpperCase();
        for (Task.Priority priority : Task.Priority.values()) {
            if (priority.toString().equals(value)) {
                return value;
            }
        }
        throw new NoSuchPriorityException("There is no such priority, try again");
    }
}
