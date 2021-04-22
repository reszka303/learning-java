package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

import java.math.BigInteger;

public class Person {
    private String firstName;
    private String secondName;
    private int id;

    public Person(String firstName, String secondName, int id) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " " + id;
    }
}
