package javaStart.task34_Queue.exercise2.io;

import javaStart.task34_Queue.exercise2.model.Task;

import java.util.Scanner;
import java.util.TreeSet;

public class ConsolePrinter {
    private Scanner input = new Scanner(System.in);
    public void printTask(TreeSet<Task> taskTreeSet) {
        for (Task task : taskTreeSet) {
            printLine(task.toString());
        }
    }

    public String readCategoryFromUser() {
        printLine("Enter a name of priority to display statistics");
        printLine("Enter: High, moderate or low");
        return input.nextLine();
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
