package javaStart.task16_Inheritance.exercise2;

public class CourseApp {
    public static void main(String[] args) {
        OnlineCourse onlineCourse1 = new OnlineCourse(
                "Java-Online 123",
                239,
                "Course JavaStart Online",
                "The best programming course of Java",
                600,
                1200);

        StationaryCourse stationaryCourse1 = new StationaryCourse(
                "Java-Stationary 123",
                2000,
                "Course JavaStart Stationary",
                "The best stationary programming course of Java",
                "Warsaw",
                60);

        Bootcamp bootcamp1 = new Bootcamp(
                "Java-Bootcamp 123",
                5000,
                "Bootcamp JavaStart",
                "The best bootcamp of Java",
                600,
                1200,
                new Teacher(
                        "Gregory",
                        "Peck"),
                36);

        System.out.println(onlineCourse1.printInfo());
        System.out.println(stationaryCourse1.printInfo());
        System.out.println(bootcamp1.printInfo());
    }
}
