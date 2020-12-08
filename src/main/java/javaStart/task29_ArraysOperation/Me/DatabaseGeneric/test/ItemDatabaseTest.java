package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.test;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.CheckDuplicateException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.Item;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.ItemDatabase;

public class ItemDatabaseTest {
    public static void main(String[] args) {
        ItemDatabase itemDatabase = new ItemDatabase();
        Item gregoryPeck = new Item("Gregory", "Peck", "Los Angeles", 'M', "123");
        Item leonardoDiCaprio = new Item("Leonard", "DiCaprio", "New York", 'M', "124");
        Item nicoleKidman = new Item("Nicole", "Kidman", "Melbourne", 'W', "125");

        try {
            itemDatabase.addPerson(gregoryPeck);
            itemDatabase.addPerson(leonardoDiCaprio);
            itemDatabase.addPerson(nicoleKidman);
            System.out.println("Persons in a database after added:");
            System.out.println();
            for (Item itemInCollection : itemDatabase.getPerson()) {
                System.out.println(itemInCollection.toStringPerson());
            }
        } catch (CheckDuplicateException e) {
            e.getMessage();
        }

        System.out.println();
        System.out.println("Persons in a database after removed:");
        System.out.println();
        itemDatabase.removePerson(gregoryPeck);
        for (Item itemInCollection : itemDatabase.getPerson()) {
            System.out.println(itemInCollection.toStringPerson());
        }

        System.out.println();
        System.out.println("Persons in a database after Gregory Peck added again:");

        try {
            itemDatabase.addPerson(gregoryPeck);
            System.out.println();
            for (Item itemInCollection : itemDatabase.getPerson()) {
                System.out.println(itemInCollection.toStringPerson());
            }
        } catch (CheckDuplicateException e) {
            e.getMessage();
        }
    }
}
