package javaStart.task23_AbstractTypes.exercise2.Me;

public class EmployeeFullTime extends Employee {
    private static final double bonus = 0.05;
    private static final double weeklyWorkHours = 40.0;
    private double hourlyRate;

    public EmployeeFullTime(String firstName, String lastName, String id, double hourlyRate) {
        super(firstName, lastName, id);
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateAnnualSalary() {
        return calculateMonthlySalary() * 12 + calculatePercentage();
    }

    private double calculatePercentage() {
        return calculateMonthlySalary() * 12 * bonus;
    }

    @Override
    double calculateMonthlySalary() {
        return weeklyWorkHours * 4 * hourlyRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFirstName() + ", " );
        sb.append(getLastName() + ", ");
        sb.append("Id: ");
        sb.append(getId() + ", ");
        sb.append("Monthly salary: ");
        sb.append(calculateMonthlySalary() + " €, ");
        sb.append("Annual salary: ");
        sb.append(calculateAnnualSalary() + " €" );

        return sb.toString();
    }
}
