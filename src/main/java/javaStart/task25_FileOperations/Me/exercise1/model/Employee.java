package javaStart.task25_FileOperations.Me.exercise1.model;

public class Employee extends Person {
    private double salary;

    public Employee(String name, String surname, String id, double salary) {
        super(name, surname, id);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary: " + salary;
    }

    @Override
    public String getShortInfo() {
        return super.getShortInfo();
    }
}
