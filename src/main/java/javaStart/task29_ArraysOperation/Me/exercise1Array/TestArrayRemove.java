package javaStart.task29_ArraysOperation.Me.exercise1Array;

import javaStart.task29_ArraysOperation.Me.exercise1Array.Person;
import javaStart.task29_ArraysOperation.Me.exercise1Array.PersonDatabase;

import java.util.Arrays;

public class TestArrayRemove {
    public static void main(String[] args) {
        PersonDatabase database = new PersonDatabase();

        Person gregoryPeck = new Person(
                "Gregory", "Peck", "10");
        Person leonardoDiCaprio = new Person(
                "Leonardo", "DiCaprio", "20");

        database.add(gregoryPeck);
        database.add(leonardoDiCaprio);
        System.out.println(database);

    }
}
