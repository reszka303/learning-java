package javaStart.task29_ArraysOperation.Me.exercise1Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDatabase {
    private final int INITIAL_CAPACITY = 1;
    private Person[] people = new Person[INITIAL_CAPACITY];
    private int personNumber = 0;
    private int indexToRemove = 0;
    private List<Person> peopleList = new ArrayList<>();
    private Person[] copyPeople = new Person[INITIAL_CAPACITY];
    private int sizeCopyPeople = 0;

    void add(Person person) {
        if (person == null) {
            throw new NullPointerException("Person cannot be null");
        }
        if (personNumber == people.length) {
            people = Arrays.copyOf(people, people.length + 1);
        }
        people[personNumber] = person;
        personNumber++;
    }

    void remove(Person person) {
//        peopleList.remove(person);
        for (int i = 0; i < people.length; i++) {
            if (!people[i].getPesel().equals(person.getPesel())) {
                indexToRemove = i;
                sizeCopyPeople++;
            }
        }
//        people = System.arraycopy(people, 0, copyPeople, 0, people.length - indexToRemove);

    }
    

    @Override
    public String toString() {
        return "" + Arrays.toString(people);
    }
}
