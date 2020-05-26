package javaStart.task17_Super.exercise1;

public class Apple extends Fruit {
    private static final String TYPE = "Apple";
    private String variety;

    public Apple(double weight, String variation) {
        super(weight, TYPE);
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    String getInfo() {
        return super.getInfo() + "\n" + "Variety: " + variety;
    }
}
