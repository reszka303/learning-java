package javaStart.task23_AbstractTypes.exercise2.Me;


import java.util.InputMismatchException;

public class EmployeeControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Company company = new Company();

    void run() {
        menu();
    }

    private void menu() {
        Option option;

        do {
            printOption();
            option = getOption();
            switch (option) {
                case ADD_EMPLOYEE_FULL_TIME:
                    addEmployeesFullTime();
                    break;
                case ADD_EMPLOYEE_PART_TIMER:
                    addEmployeesPartTimer();
                    break;
                case PRINT_EMPLOYEE_FULL_TIME:
                    printEmployeesFullTime();
                    break;
                case PRINT_EMPLOYEE_PART_TIMER:
                    printEmployeesPartTimer();
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

        while (!optionOk){
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLineError(e.getMessage() + ", provide again:");
            } catch (InputMismatchException e) {
                printer.printLineError("You entered a value that " +
                        "is not a number, please enter again:");
            }
        }
        return option;
    }

    private void addEmployeesFullTime() {
        try {
            Employee employee = dataReader.createEmployeeFullTime();
            company.addEmployeesFullTime(employee);
        } catch (DuplicateException e) {
            printer.printLineError("The employee with the given" +
                    " identifier is already in the database: " +
                    e.getEmployee().getFirstName()+ " " +
                    e.getEmployee().getLastName()+ " " +
                    e.getEmployee().getId());
        }
    }

    private void addEmployeesPartTimer(){
        try {
            Employee employee = dataReader.createEmployeePartTimer();
            company.addEmployeesPartTimer(employee);
        } catch (DuplicateException e) {
            printer.printLineError("The employee with the given" +
                    " identifier is already in the database: " +
                    e.getEmployee().getFirstName()+ " " +
                    e.getEmployee().getLastName()+ " " +
                    e.getEmployee().getId());
        }
    }

    private void printEmployeesFullTime() {
        printer.printEmployeeFullTime(company.getEmployees());
    }

    private void printEmployeesPartTimer() {
        printer.printEmployeePartTimer(company.getEmployees());
    }

    private void printOption() {
        printer.printLine("Choose an option:");
        for (Option option:
             Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private void exit() {
        printer.printLine("End of program, bye!");
        dataReader.close();
    }
}
