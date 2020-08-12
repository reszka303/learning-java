package javaStart.task25_FileOperations.Me.exercise1.app;

import javaStart.task25_FileOperations.Me.exercise1.exception.DataExportException;
import javaStart.task25_FileOperations.Me.exercise1.exception.DataImportException;
import javaStart.task25_FileOperations.Me.exercise1.exception.DuplicateException;
import javaStart.task25_FileOperations.Me.exercise1.exception.NoSuchOptionException;
import javaStart.task25_FileOperations.Me.exercise1.io.ConsolePrinter;
import javaStart.task25_FileOperations.Me.exercise1.io.DataReader;
import javaStart.task25_FileOperations.Me.exercise1.io.file.FileManager;
import javaStart.task25_FileOperations.Me.exercise1.io.file.FileManagerBuilder;
import javaStart.task25_FileOperations.Me.exercise1.model.Company;
import javaStart.task25_FileOperations.Me.exercise1.model.Employee;

import java.util.InputMismatchException;
import java.util.List;

public class CompanyControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;

    private Company company;

    CompanyControl() {
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            company = fileManager.importData();
            printer.printLine("Imported data from a file");
        } catch (DataImportException e) {
            printer.printLine(e.getMessage());
            printer.printLine("A new base has been initiated");
            company = new Company();
        }
    }

    void run() {
        menu();
    }

    private void menu() {
        Option option;

        do {
            printOption();
            option = getOption();
            switch (option) {
                case ENTERING_EMPLOYEE_DATA:
                    addEmployee();
                    break;
                case LOAD_AND_DISPLAY_DATA_FROM_A_FILE:
                    printEmployees();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("There is no such option, please enter again: ");
            }

        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLineError(e.getMessage() + ", provide again:");
            } catch (InputMismatchException e) {
                printer.printLineError("You entered a value that is" +
                        " not a number, please enter again:");
            }
        }
        return option;
    }

    private void addEmployee() {
        Employee employee = dataReader.createEmployee();
        try {
            company.addEmployee(employee);
        } catch (DuplicateException e) {
            printer.printLineError("The employee with the given" +
                    " identifier is already in the database: " +
                    e.getEmployee().getShortInfo());
        }
    }

    private void printEmployees() {
        List<Employee> employees = company.getEmployees();
        printer.printEmployee(employees);
    }

    void printOption() {
        for (Option option:
             Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private void exit() {
        try {
            fileManager.exportData(company);
            printer.printLine("Successful data export to file");
        } catch (DataExportException e) {
            printer.printLineError(e.getMessage());
        }
        dataReader.close();
        printer.printLine("End of program, bye!");
    }

    private enum Option {
        EXIT(0, "Exit"),
        ENTERING_EMPLOYEE_DATA(1, "Entering employee data"),
        LOAD_AND_DISPLAY_DATA_FROM_A_FILE(2, "Load and display data from a file");


        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("No option with id " + option);
            }
        }
    }
}
