package javaStart.task23_AbstractTypes.exercise2.JS;

class PartTimeEmployee extends Employee {
    private int hours;
    private double hourlyWage;

    public PartTimeEmployee(String firstName, String lastName, int hours, double hourlyWage) {
        super(firstName, lastName);
        this.hours = hours;
        this.hourlyWage = hourlyWage;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    double getMonthlySalary() {
        return hours * hourlyWage;
    }

    @Override
    double getYearlySalary() {
        return getMonthlySalary() * NO_OF_MONTHS;
    }
}