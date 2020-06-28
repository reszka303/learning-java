package javaStart.task23_AbstractTypes.exercise2.Me;

public class EmployeePartTimer extends Employee {
    private double workHours;
    private double hourlyRate;

    public EmployeePartTimer(String firstName, String lastName, String id,
                             double workHours, double hourlyRate) {
        super(firstName, lastName, id);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }


    @Override
    double calculateAnnualSalary() {
        return calculateMonthlySalary() * 12;
    }

    @Override
    double calculateMonthlySalary() {
        return workHours * hourlyRate;
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
