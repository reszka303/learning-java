package javaStart.task16_Inheritance.exercise2;

public class OnlineCourse extends Course {
    private int durationVideo;
    private int durationCourse;

    public OnlineCourse(String id, double price, String name,
                        String description, int durationVideo,
                        int durationCourse) {
        super(id, price, name, description);
        this.durationVideo = durationVideo;
        this.durationCourse = durationCourse;
    }

    public int getDurationVideo() {
        return durationVideo;
    }

    public void setDurationVideo(int durationVideo) {
        this.durationVideo = durationVideo;
    }

    public int getDurationCourse() {
        return durationCourse;
    }

    public void setDurationCourse(int durationCourse) {
        this.durationCourse = durationCourse;
    }

    String printInfo() {
        String info =
                "Online course:" + "\n" +
                "Id: " + getId() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Duration video: " + durationVideo + "\n" +
                "Duration course: " + durationCourse + "\n";
        return info;
    }
}
