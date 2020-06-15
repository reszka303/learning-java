package javaStart.task22_Exceptions.exercise2.Me;

import java.util.Objects;

class Participant {
    private String firstName;
    private String surname;
    private String id;
    private int age;

    public Participant() {
    }

    public Participant(String firstName, String surname, String id, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.id = id;
        this.age = age;
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

    public int getAge() {
        return age;
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

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, id, age);
    }

    @Override
    public String toString() {
        return firstName + " " + surname + ", id: " + id + ", age: " + age;

    }
}
