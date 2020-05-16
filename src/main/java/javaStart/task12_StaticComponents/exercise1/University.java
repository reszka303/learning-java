package javaStart.task12_StaticComponents.exercise1;

public class University {
    public static void main(String[] args) {
        Student student = new Student();
        Student jaxWebster = new Student(
                "Jax",
                "Webster",
                1);

        Student morrisCampbell = new Student(
                "Morris",
                "Campell",
                2);

        System.out.println("Number of students is as follows: " +
                Student.getNumberOfStudents());
        student.printNumberOfStudents();
    }
}
