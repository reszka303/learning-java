package javaStart.task16_Inheritance.exercise2;

public class Bootcamp extends OnlineCourse {
    private Teacher teacher;
    private int consultationHours;

    public Bootcamp(String id, double price, String name,
                    String description, int durationVideo,
                    int durationCourse, Teacher teacher,
                    int consultationHours) {
        super(id, price, name, description, durationVideo, durationCourse);
        this.teacher = teacher;
        this.consultationHours = consultationHours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getConsultationHours() {
        return consultationHours;
    }

    public void setConsultationHours(int consultationHours) {
        this.consultationHours = consultationHours;
    }

    String printInfo() {
        String info =
                "Bootcamp:" + "\n" +
                "Id: " + getId() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Teacher: " + "\n" +
                "First name: " + getTeacher().getFirstName() + "\n" +
                "Last name: " + getTeacher().getLastName() + "\n" +
                "Consultations hours: " + consultationHours + "\n";
        return info;
    }
}
