package javaStart.task38_MethodReference.exercise2;

public enum Employment {
    FULL_TIME, PART_TIME, CONTRACT;

    boolean checkEmployeeEmployment(Employee employee) {
        return this == employee.getEmployment();
    }
}
