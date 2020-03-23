package javaStart.task6_Encapsulation.JavaStartSolution;

public class Client {
    private String firstName;
    private String lastName;
    private boolean premium;


    public Client(String firstName, String lastName, boolean premium) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.premium = premium;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }


    @Override
    public String toString() {
        return " " + firstName + lastName + premium;
    }
}

