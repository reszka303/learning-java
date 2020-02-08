package kodilla.modul1.creatingObjectsUsingTheAbstractClass;

public class FullTimeEmployee extends Employee {
    private double payoff;
    private int bonus;
    boolean isAdditionalSale;

    public FullTimeEmployee(String name, String surname, double payoff,
                            int bonus, boolean isAdditionalSale) {
        super(name, surname);
        this.payoff = payoff;
        this.bonus = bonus;
        this.isAdditionalSale = isAdditionalSale;
    }

    public void wayOfCalculatingSalary() {
        double additionalSale = 0;

        if (isAdditionalSale) {
            additionalSale =  payoff * bonus / 100;
            double totalSalary = payoff + additionalSale;
            System.out.println(getName() + " " + getSurname() + "'s "
                    + "salary is: " + totalSalary);
        } else {
            System.out.println(getName() + " " + getSurname() + "'s "
                    + "salary is: " + payoff);
        }
    }
}
