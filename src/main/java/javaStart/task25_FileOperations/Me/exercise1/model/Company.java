package javaStart.task25_FileOperations.Me.exercise1.model;

import javaStart.task25_FileOperations.Me.exercise1.exception.DuplicateException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        checkDuplicate(employee);
        employees.add(employee);
    }

    private void checkDuplicate(Employee employee) {
        for (int i = 0; i < employees.size() ; i++) {
            if (employees.get(i).getId().equals(employee.getId())) {
                throw new DuplicateException(employee);
            }
        }
    }
}
