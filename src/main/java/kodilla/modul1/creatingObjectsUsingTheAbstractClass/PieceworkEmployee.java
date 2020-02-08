package kodilla.modul1.creatingObjectsUsingTheAbstractClass;

public class PieceworkEmployee extends Employee {
    private int hourlyRate;
    private int product;

    public PieceworkEmployee(String name, String surname, int hourlyRate, int product) {
        super(name, surname);
        this.hourlyRate = hourlyRate;
        this.product = product;
    }

    public void wayOfCalculatingSalary() {
        double salary = hourlyRate * product;
        System.out.println(getName() + " "+ getSurname()+ "'s " + "salary is: " + salary);
    }
}
