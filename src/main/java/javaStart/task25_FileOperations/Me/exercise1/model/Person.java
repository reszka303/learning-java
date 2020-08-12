package javaStart.task25_FileOperations.Me.exercise1.model;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String surname;
    private String id;

    public Person(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return  name + " " + surname + ", id: " + id;
    }

    public String getShortInfo() {
        return name + " " + surname;
    }
}
