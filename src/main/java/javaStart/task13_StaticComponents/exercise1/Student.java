package javaStart.task13_StaticComponents.exercise1;

public class Student {
    private static int NUMBER_OF_STUDENTS = 0;

    private String firstName;
    private String surname;
    private int indexNumber;

    public Student(String firstName, String surname, int indexNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.indexNumber = indexNumber;
        NUMBER_OF_STUDENTS++;
    }

    public Student() {
    }

    public static int getNumberOfStudents() {
        return NUMBER_OF_STUDENTS;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    void printNumberOfStudents() {
        System.out.println("Number of students is as follows: " +
                Student.getNumberOfStudents());
    }
}
