package javaStart.task23_AbstractTypes.exercise2.Me;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private String id;

    public Employee(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    abstract double calculateAnnualSalary();

    abstract double calculateMonthlySalary();

    @Override
    public String toString() {
        return "";
    }

    public String getShortInfo() {
        return firstName + " " + lastName + " " + id;
    }
}
