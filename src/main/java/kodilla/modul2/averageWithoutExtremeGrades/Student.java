package kodilla.modul2.averageWithoutExtremeGrades;

public class Student {
    String firstName;
    String surName;

    public Student(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Student: " + firstName + surName;
    }
}
