package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model;


import java.io.Serializable;
import java.util.Objects;

public class Item<K, V, I, R, T> implements Serializable {
    private K k;
    private V v;
    private I i;
    private T t;
    private R r;


    public Item(K k, V v, I i, T t, R r) {
        this.k = k;
        this.v = v;
        this.i = i;
        this.t = t;
        this.r = r;

    }

    public Item(I i) {
        this.i = i;
    }

    public Item() {
    }

    public I getI() {
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item<?, ?, ?, ?, ?> item = (Item<?, ?, ?, ?, ?>) o;
        return i.equals(item.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    public String toStringPerson() {
        var sb = new StringBuilder();
        sb.append("First name: " + k +",");
        sb.append(" Second name: " + v + ",");
        sb.append(" Pesel: " + i + ",");
        sb.append(" Place of birth: " + t + ",");
        sb.append(" Gender: " + r.toString().toUpperCase());
        return  sb.toString();
    }

    private String statusDamage() {
        String statusDamage = "damaged";
        String statusUndamaged = "undamaged";
        if ((r) == Boolean.valueOf(true)) {
            return statusDamage;
        } else {
            return statusUndamaged;
        }
    }

    public String toStringCar() {
        var sb = new StringBuilder();
        String statusDamage = statusDamage();

        sb.append("Mark: " + k +",");
        sb.append(" Model: " + v + ",");
        sb.append(" Vin: " + i + ",");
        sb.append(" Engine capacity (ccm3): " + t + ",");
        sb.append(" Damaged? " + statusDamage);
        return  sb.toString();
    }
}
