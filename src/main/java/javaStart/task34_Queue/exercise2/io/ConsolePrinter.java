package javaStart.task34_Queue.exercise2.io;

import javaStart.task34_Queue.exercise2.exception.EmptyDatabaseWithPriorityException;
import javaStart.task34_Queue.exercise2.model.Task;

import java.util.*;

public class ConsolePrinter {
    private Scanner input = new Scanner(System.in);

    public void printTasksByPriority(Queue<Task> taskQueue, Task.Priority priority) {
        if (taskQueue.isEmpty()) {
            printLine("There is no tasks in the database");
        }

        for (Task element : taskQueue) {
            if (priority.equals(element.getPriority())) {
                printLine(element.toString());
            }


//            } else if (element.isEmpty()) {
//                throw new EmptyDatabaseWithPriorityException("The database is empty with " +
//                        "the following priority: " + priority);
//            }

//            else if (element.getPriority().equals(null) && element.getPriority().equals(priority)) {
//                throw new EmptyDatabaseWithPriorityException("The database is empty with " +
//                        "the following priority: " + priority);
//            }

//            if (element.toString().isEmpty() || element.toString() == null ||
//                    priority.toString().isEmpty() || priority.toString() == null) {
//                throw new EmptyDatabaseWithPriorityException("The database is empty with " +
//                            "the following priority: " + priority);
//            }
        }
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
