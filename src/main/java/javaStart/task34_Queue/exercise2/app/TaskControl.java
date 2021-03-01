package javaStart.task34_Queue.exercise2.app;

import javaStart.task34_Queue.exercise2.exception.*;
import javaStart.task34_Queue.exercise2.io.ConsolePrinter;
import javaStart.task34_Queue.exercise2.io.DataReader;
import javaStart.task34_Queue.exercise2.model.Task;
import javaStart.task34_Queue.exercise2.io.file.CsvFileManager;
import javaStart.task34_Queue.exercise2.model.TaskManager;

import java.util.*;

public class TaskControl {
    private Scanner input = new Scanner(System.in);
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private TaskManager taskManager;
    private CsvFileManager csvFileManager = new CsvFileManager();

    public TaskControl() {
        try {
            taskManager = csvFileManager.readData();
            printer.printLine("Read data from a file");
        } catch (DataReadException e) {
            e.getMessage();
            printer.printLine("A new database has been initiated");
            taskManager = new TaskManager();
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
                case EXIT:
                    exit();
                    break;
                case ADD_TASK:
                    addTask();
                    break;
                case REMOVE_TASK:
                    removeTask();
                    break;
                case PRINT_TASK_BY_PRIORITY:
                    printTaskByPriority();
                    break;
                case PRINT_ALL_TASKS:
                    printAllTasks();
                    break;
            }
        } while (option != Option.EXIT);
    }

    private void exit() {
        try {
            csvFileManager.writeData(taskManager);
            printer.printLine("Write data into a file has finished successfully");
        } catch (DataWriteException e) {
            e.getMessage();
        }
        dataReader.close();
        printer.printLine("Exit program");
    }

    private void addTask() {
        Task task = dataReader.createTask();
        try {
            taskManager.addTask(task);
            printer.printLine("Task has been added to the database");
        } catch (NameTaskAlreadyExistException e) {
            e.getMessage();
        }
    }

    private void removeTask() {
        try {
            Task task = dataReader.writeName();
            if (taskManager.removeTask(task)) {
                printer.printLine("The task has been removed from the database");
            }
        } catch (NoIndicatedTaskException e) {
            e.getMessage();
        }
    }

    private void printTaskByPriority() {
        Queue<Task> taskQueue = taskManager.getTaskQueue();
        Task.Priority priority = readPriorityFromUser();
        boolean foundPriority = taskManager.findPriority(priority);
        printer.printFoundPriority(foundPriority, priority);
        printer.printTasksByPriority(taskQueue, priority);
    }

    private void printAllTasks() {
        printer.printAllTasks(taskManager.getTaskQueue());
    }

    private Task.Priority readPriorityFromUser() {
        printer.printLine("Enter the priority to display task with this priority");
        printer.printPriority();
        printer.printLine("");
        String value = getPriority();
        return Task.Priority.valueOf(value);
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

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;

        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (InputMismatchException e) {
                printer.printLineError("Enter a digit, try again");
            } catch (ArrayIndexOutOfBoundsException | NoSuchOptionException e) {
                e.getMessage();
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
        EXIT(0, "Exit"),
        ADD_TASK(1, "Add task"),
        REMOVE_TASK(2, "Remove task"),
        PRINT_TASK_BY_PRIORITY(3, "Print task by priority"),
        PRINT_ALL_TASKS(4, "Print all tasks");

        private int value;
        private String description;

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
}
