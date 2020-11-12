package javaStart.task29_ArraysOperation.Me.exercise1Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDatabase {
    private final int INITIAL_CAPACITY = 1;
    private Person[] people = new Person[INITIAL_CAPACITY];
    private List<Person> peopleList = new ArrayList<>();

    void add(Person person) {
        peopleList.addAll(Arrays.asList(people));
        peopleList.add(person);
        remove(null);
    }

    void remove(Person person) {
        peopleList.remove(person);
    }
    

    @Override
    public String toString() {
        return "" + peopleList.toString();
    }
}
