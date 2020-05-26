package javaStart.task17_Super.exercise1;

public class Fruit {
    private double weight;
    private String type;

    public Fruit(double weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String getInfo() {
        String info =
                "Weight: " + weight + " g" + "\n" +
                "Type: " + type;
        return info;
    }
}
