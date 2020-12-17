package javaStart.task33_Maps.exercise1.oneClassVersion;

import java.util.*;

public class CompanyApp {
    private static final int EXIT_PROGRAM = 0;
    private static final int ADD_EMPLOYEE = 1;
    private static final int SEARCH_EMPLOYEE = 2;

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        mainLoop();
    }

    private static void mainLoop() {
        int option;
        Company company = new Company();

        do {
            printOption();
            option = getOption();
            switch (option) {
                case EXIT_PROGRAM:
                    exit();
                    break;
                case ADD_EMPLOYEE:
                    Employee employee = Company.create();
                    Company.add(employee);
                    break;
                case SEARCH_EMPLOYEE:
                    Company.findEmployee(company);
                    break;
            }
        } while (option != EXIT_PROGRAM);
    }

    private static int getOption() {
        boolean optionOk = false;
        int option = 0;

        while (!optionOk) {
            try {
                option = getOptionDigit();
                optionOk = true;
            } catch (InputMismatchException e) {
                printLineError("Enter a digit, try again");
            } catch (NoSuchOptionException e) {
                e.getMessage();
            } catch (PositiveNotFoundException e) {
                e.getMessage();
            } finally {
                clearBuffer();
            }
        }
        return option;
    }

    private static int getOptionDigit() {
        int zero = 0;
        int maxOption = SEARCH_EMPLOYEE;
        int option;

        option = input.nextInt();

        if (option < zero) {
            throw new PositiveNotFoundException("Number must be positive, try again");
        } else if (option > maxOption) {
            throw new NoSuchOptionException("There is no option " + option);
        } else {
            return option;
        }
    }

    private static void exit() {
        printLine("Exit program");
    }

    private static class NoSuchOptionException extends RuntimeException {
        public NoSuchOptionException(String message) {
            printLineError(message);
        }
    }

    private static void printOption() {
        printLine("Exit program - 0");
        printLine("Add employee - 1");
        printLine("Search employee - 2");
    }

    private static class PositiveNotFoundException extends RuntimeException {
        public PositiveNotFoundException(String message) {
            printLineError(message);
        }
    }

    private static class Company {
        private static Map<String, Employee> employees = new HashMap<>();

        private static void add(Employee employee) {
            employees.put(employee.getFirstName().concat(employee.getLastName()), employee);
            printLine("Employee has been added to the database");
        }

        private static Employee create() {
            printLine("Give a first name:");
            String firstName = input.nextLine();
            printLine("Give a last name:");
            String lastName = input.nextLine();
            printLine("Give a salary");
            double salary = getSalary();

            return new Employee(firstName, lastName, salary);
        }

        Employee getEmployee(String firstName, String lastName) {
            String key = firstName.concat(lastName);
            return employees.get(key);
        }

        private static void findEmployee(Company company) {
            System.out.println("Give a first name:");
            String firstName = input.nextLine();
            System.out.println("Give a last name:");
            String lastName = input.nextLine();

            Employee employee = company.getEmployee(firstName, lastName);
            if (employee == null) {
                printLine("There is no employee");
            } else {
                printLine(employee.toString());
            }
        }

        private static double getSalary() {
            boolean salaryOk = false;
            double salary = 0;

            while (!salaryOk) {
                try {
                    salary = getDigit();
                    salaryOk = true;
                } catch (InputMismatchException e) {
                    printLineError("Enter a digit, try again");
                } catch (PositiveNotFoundException e) {
                    e.getMessage();
                } finally {
                    clearBuffer();
                }
            }
            return salary;
        }

        private static double getDigit() {
            int zero = 0;
            double price;

            price = input.nextDouble();
            if (price <= zero) {
                throw new PositiveNotFoundException("Price must be positive " +
                        "and higher than zero, try again");
            } else {
                return price;
            }
        }
    }

    private static class Employee {
        private String firstName;
        private String lastName;
        private double salary;

        public Employee(String firstName, String lastName, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + " " + salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }

    private static void clearBuffer() {
        input.nextLine();
    }
}
