package kodilla.modul1.creatingObjectsUsingTheAbstractClass;

public abstract class Employee {
    private final String name;
    private final String surname;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    abstract void wayOfCalculatingSalary();

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}



