package javaStart.task19_ObjectMethods.lesson;

import java.util.Objects;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //ustandaryzowany sposób w jaki sposób należy porównywac dwa obiekty


    @Override
    public boolean equals(Object o) {
        if (this == o) //sprawdza czy referencja obiektu this jest równa referencji obiektowi o
            return true;
        if (o == null || getClass() != o.getClass()) //sprawdza czy obiekt o jest równy null lub czy
            return false; // czy obiekt o jest inny niż klasa Student
        //w przypdku instanceof sprawdza się również klasy nadrzędne, które dziedziczy klasa Student
        Student student = (Student) o; //po sprawdzeniu możemy obiekt o rzutować na klasę Student i
        //obiekt o przypisać do zmiennej referencyjnej student
        return age == student.age && Objects.equals(name, student.name); //wtedy zaczynamy porównywać
        //poszczególne pola klasy w zależności od ich typów
        //pole age z uwagi na to, że to int porównujemy zwykłym operatorem porównania a name jako String
        //specjalnie przygotowaną klasą equals zaimplementowana w klasie Objects
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
