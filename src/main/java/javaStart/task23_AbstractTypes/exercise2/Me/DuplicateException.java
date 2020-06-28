package javaStart.task23_AbstractTypes.exercise2.Me;

public class DuplicateException extends RuntimeException {
    private Employee employee;

    public DuplicateException(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
