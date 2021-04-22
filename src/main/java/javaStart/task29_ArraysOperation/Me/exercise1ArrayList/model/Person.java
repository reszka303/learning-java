package javaStart.task29_ArraysOperation.Me.exercise1ArrayList.model;

import java.math.BigInteger;
import java.util.Objects;

public class Person {
    private String firstName;
    private String secondName;
    private BigInteger id;

    public Person(String firstName, String secondName, BigInteger id) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
    }

    public Person(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public BigInteger getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "" + firstName + " " + secondName + " " + id;
    }
}
