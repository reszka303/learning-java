package javaStart.task7_Encapsulation.exercise1.MySolution;

public class Client {
    private String firstName;
    private String lastName;
    private boolean premium;
    private double price;

    public Client(String firstName, String lastName, boolean premium, double price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.premium = premium;
        this.price = price;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isPremium() {
        return premium;
    }

    public double getPrice() {
        return price;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    protected void printInfo() {
        if (premium == true) {
            System.out.println(firstName + " " + lastName + " premium client " + price);
        } else {
            System.out.println(firstName + " " + lastName + " standard client " + price);
        }
    }
}
