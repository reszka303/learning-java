package javaStart.task18_Polymorphism.exercise1;

public class Hospital {
    private static final int MAX_EMPLOYEES = 10;
    private Person[] employees = new Person[MAX_EMPLOYEES];
    private int employeesNumber = 0;

    void addPerson(Person person) {
        if (employeesNumber < MAX_EMPLOYEES) {
            employees[employeesNumber] = person;
            employeesNumber++;
        } else {
            System.out.println("The maximal number of persons" +
                    " has been reached");
        }
    }

    String getInfo() {
        String result = "";
        if (employeesNumber == 0) {
            System.out.println("There is no person");
        }
        for (int i = 0; i < employeesNumber ; i++) {
            result = result + employees[i].getInfo() + "\n";
        }
        return result;
    }
}
