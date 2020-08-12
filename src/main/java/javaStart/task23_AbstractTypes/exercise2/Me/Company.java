package javaStart.task23_AbstractTypes.exercise2.Me;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    void addEmployee(Employee employee) {
        checkDuplicate(employee);
        employees.add(employee);
    }

    private void checkDuplicate(Employee employee) {
        for (int i = 0; i < employees.size() ; i++) {
            if (employees.get(i).getId().equals(employee.getId()))
                throw new DuplicateException(employee);
        }
    }
}
