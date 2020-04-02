package javaStart.task2_AggregationAndComposition.exercise2;

public class Address {
    private String city;
    private String postalCode;
    private String street;
    private String homeNo;
    private String flatNo;

    public Address(String city, String postalCode, String street, String homeNo, String flatNo) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.homeNo = homeNo;
        this.flatNo = flatNo;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public String getFlatNo() {
        return flatNo;
    }
}
