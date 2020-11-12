package javaStart.task29_ArraysOperation.Me.exercise1Array;

import java.util.Objects;

public class Person {
    private String firstName;
    private String secondName;
    private String pesel;

    public Person(String firstName, String secondName, String pesel) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return pesel.equals(person.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }

    @Override
    public String toString() {
        return "" + firstName + " " + secondName + " " + pesel;
    }
}
