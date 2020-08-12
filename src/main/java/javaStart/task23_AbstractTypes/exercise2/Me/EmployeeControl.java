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
        Employee employee = dataReader.createEmployeeFullTime();
        addEmployee(employee);
    }

    private void addEmployeesPartTimer(){
        Employee employee = dataReader.createEmployeePartTimer();
        addEmployee(employee);
        }

    private void addEmployee(Employee employee) {
        try {
            company.addEmployee(employee);
        } catch (DuplicateException e) {
            printer.printLineError("The employee with the given" +
                    " identifier is already in the database: " +
                    e.getEmployee().getShortInfo());
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

    private enum Option {
        EXIT(0, "Exit the program"),
        ADD_EMPLOYEE_FULL_TIME(1, "Addition employee full-time"),
        ADD_EMPLOYEE_PART_TIMER(2, "Addition employee part-timer"),
        PRINT_EMPLOYEE_FULL_TIME(3, "Display employee full-time"),
        PRINT_EMPLOYEE_PART_TIMER(4, "Display employee part-timer");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("No option with id " + option);
            }
        }
    }
}
