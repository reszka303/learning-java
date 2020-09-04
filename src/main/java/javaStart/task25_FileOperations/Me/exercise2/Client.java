package javaStart.task25_FileOperations.Me.exercise2;

class Client {
    private int id;
    private String firstName;
    private String surname;
    private String country;
    private double value;

    public Client(int id, String firstName, String surname, String country, double value) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.country = country;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return id + ": " +
                firstName + " " +
                surname+ ", " +
                country + ", " +
                value + "zł";
    }
}
