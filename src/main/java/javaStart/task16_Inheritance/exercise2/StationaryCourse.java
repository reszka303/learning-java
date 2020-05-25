package javaStart.task16_Inheritance.exercise2;

public class StationaryCourse extends Course {
    private String place;
    private int numberLesson;

    public StationaryCourse(String id, double price,
                            String name, String description, String place,
                            int numberLesson) {
        super(id, price, name, description);
        this.place = place;
        this.numberLesson = numberLesson;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(int numberLesson) {
        this.numberLesson = numberLesson;
    }

    String printInfo() {
        String info =
                "Stationary course:" + "\n" +
                "Id: " + getId() + "\n" +
                "Price: " + getPrice() + "\n" +
                "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Place: " + place + "\n" +
                "Number lessons: " + numberLesson + "\n";
        return info;
    }
}
