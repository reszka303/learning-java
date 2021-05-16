package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

public abstract class Vehicle implements CsvConvertible {
    private String mark;
    private String model;

    public Vehicle(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return mark + " " + model;
    }
}
