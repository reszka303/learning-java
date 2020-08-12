package javaStart.task25_FileOperations.Me.exercise1.io;

import javaStart.task25_FileOperations.Me.exercise1.model.Employee;

import java.util.List;

public class ConsolePrinter {
    public void printEmployee(List<Employee> employees) {
        int counter = 0;
        for (Employee employee:
             employees) {
            printLine(employee.toString());
            counter++;
        }
        if (counter == 0) {
            printLine("No employees");
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
