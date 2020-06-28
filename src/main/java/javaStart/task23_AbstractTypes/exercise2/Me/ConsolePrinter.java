package javaStart.task23_AbstractTypes.exercise2.Me;

import java.util.List;

public class ConsolePrinter {

    void printEmployeeFullTime(List<Employee> employees) {
        int counter = 0;
        for (Employee employee:
             employees) {
            if (employee instanceof EmployeeFullTime) {
                printLine(employee.toString());
                counter++;
            }
        }
        if (counter == 0)
            printLine("No employees full-time in the company");
    }

    void printEmployeePartTimer(List<Employee> employees) {
        int counter = 0;
        for (Employee employee:
             employees) {
            if (employee instanceof EmployeePartTimer) {
                printLine(employee.toString());
                counter++;
            }
        }
        if (counter == 0)
            printLine("No employees part-timer in the company");
    }
    void printLine(String text) {
        System.out.println(text);
    }

    void printLineError(String text) {
        System.err.println(text);
    }
}
