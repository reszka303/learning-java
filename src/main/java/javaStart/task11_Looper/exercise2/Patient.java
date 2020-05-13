package javaStart.task11_Looper.exercise2;

public class Patient {
    private String firstName;
    private String surname;
    private String id;

    public Patient(String firstName, String surname, String id) {
        this.firstName = firstName;
        this.surname = surname;
        this.id = id;
    }

    public Patient() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(String id) {
        this.id = id;
    }

    String getInfo() {
        return firstName + " " + surname + " " + id;
    }
}
