package kodilla.modul2.averageWithoutExtremeGrades;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testAverageWithoutExtremeGrades {
    @Test
    public void displayingStudent() {
        //Given - Arrange
        Student student = new Student("Gary ", "Stacey");

        //When - Act
        System.out.println(student);
    }

    @Test
    public void displayingSchoolSubject() {
        //Given - Arrange
        SchoolSubject subject = new SchoolSubject("Information Technology");
        //When Act
        System.out.println(subject);
    }

    @Test
    public void randomGrades() {
        //Given - Arrange
        Grades grade = new Grades();
        List<Integer> grades = new ArrayList<>();

        //When - Act
        grade.random(grades);
        System.out.println("All grades are : " + grades);
    }

    @Test
    public void skipMinMax() {
        //Given - Arrange
        Grades grade = new Grades();
        List<Integer> grades = new ArrayList<>();

        //When - Act
        grade.random(grades);
        System.out.println(grades);
        System.out.println("Grades without min and max is/are: " + grade.skipMinMax(grades));
    }

    @Test
    public void calculateAverageStreamWithoutMinMax() {
        //Given - Arrange
        Grades grade = new Grades();
        List<Integer> grades = new ArrayList<>();

        //When - Act
        grade.random(grades);
        System.out.println(grades);
        System.out.println("Average with Stream without min and max grades is: "
                + grade.calculateAverageStreamWithoutMinMax(grades));
    }

    @Test
    public void calculateAverageLoop() {
        //Given Arrange
        Grades grade = new Grades();
        List<Integer> grades = new ArrayList<>();

        //When Act
        grade.random(grades);
        System.out.println(grades);
        System.out.println("Average from Loop with all grades is: "
                + grade.calculateAverageLoop(grades));
    }
}
