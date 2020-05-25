package javaStart.task16_Inheritance.exercise1;

public class Tire extends Part {
   private int size;
   private double width;

    public Tire(int serialNumber, String producer, String model,
                String series, int size, double width) {
        setSerialNumber(serialNumber);
        setProducer(producer);
        setModel(model);
        setSeries(series);
        this.size = size;
        this.width = width;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    String printInfo() {
        String info =
                "Producer: " + getProducer() + "\n" +
                "Model: " + getModel() + "\n" +
                "Serial number: " + getSerialNumber() + "\n" +
                "Size: " + size + "\n" +
                "Width: " + width;
        return info;
    }
}
