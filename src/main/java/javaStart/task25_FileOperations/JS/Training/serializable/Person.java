package javaStart.task25_FileOperations.JS.Training.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 3812017177088226543L;

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
}
