package javaStart.task30_ComparableComparator.Me.exercise2;

public class Property implements Comparable<Property> {
    private String city;
    private double price;
    private double area;

    public Property(String city, double price, double area) {
        this.city = city;
        this.price = price;
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public double getPricePerSquareMeter() {
        return price / area;
    }

    @Override
    public String toString() {
        return  city + ", " + " " + price + "zł, " + area + "mkw, " +
                String.format("%.2f", getPricePerSquareMeter()) + "zł/mkw";

    }

    @Override
    public int compareTo(Property property) {
        if (getPricePerSquareMeter() > property.getPricePerSquareMeter())
            return 1;
        else return -1;
    }
}
