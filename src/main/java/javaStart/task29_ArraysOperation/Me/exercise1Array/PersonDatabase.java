package javaStart.task29_ArraysOperation.Me.exercise1Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDatabase {
    private final int INITIAL_CAPACITY = 1;
    private Person[] people = new Person[INITIAL_CAPACITY];
    private int personNumber = 0;

    void add(Person person) {
        if (person == null) {
            throw new NullPointerException("Person cannot be null");
        }
        if (personNumber == people.length) {
            people = Arrays.copyOf(people, people.length * 2);
        }
        people[personNumber] = person;
        personNumber++;
    }

    boolean remove(Person person) {
        final int NOT_FOUND = -1;
        int found = NOT_FOUND;
        int i = 0;
        while (i < people.length && found == NOT_FOUND) {
            if (person.equals(people[i])) {
                found = i;
            } else {
                i++;
            }
        }

        if (found != NOT_FOUND) {
            System.arraycopy(people, found + 1, people, found, people.length - found - 1);
            personNumber--;
        }

        return found != NOT_FOUND;
    }
    

    @Override
    public String toString() {
        return "" + Arrays.toString(people);
    }
}
