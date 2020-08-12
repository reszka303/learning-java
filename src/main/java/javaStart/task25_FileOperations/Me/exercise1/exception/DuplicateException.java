package javaStart.task25_FileOperations.Me.exercise1.exception;

import javaStart.task25_FileOperations.Me.exercise1.model.Employee;

public class DuplicateException extends RuntimeException {
    private Employee employee;

    public DuplicateException(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
