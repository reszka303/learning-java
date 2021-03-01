package javaStart.task34_Queue.exercise2.io;

import javaStart.task34_Queue.exercise2.model.Task;

import java.util.*;

public class ConsolePrinter {
    public void printTasksByPriority(Queue<Task> taskQueue, Task.Priority priority) {
        if (taskQueue.isEmpty()) {
            printLine("There is no tasks in the database");
        }
//        int counter = 0;
        for (Task element : taskQueue) {
            if (priority.equals(element.getPriority())) {
//                counter++;
                printLine(element.toString());
            }
        }
//        if (counter == 0) {
//            printLine("There is no task with priority " + priority);
//        }
    }

    public void printFoundPriority(boolean foundPriority, Task.Priority priority) {
        if (!foundPriority)
            printLine("There is no task with priority " + priority);
    }


    public void printAllTasks(Queue<Task> taskQueue) {
        if (taskQueue.isEmpty()) {
            printLine("There is no tasks in the database");
        }

        for (Task task : taskQueue) {
            printLine(task.toString());
        }
    }

    public void printPriority() {
        int counter = 0;
        for (Task.Priority priority : Task.Priority.values()) {
            counter++;
            if (Task.Priority.values().length == counter) {
                printNoLine("" + priority.toString());
            } else {
                printNoLine(priority.toString() + ", ");
            }
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printNoLine(String text) {
        System.out.print(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
