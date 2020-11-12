package javaStart.task29_ArraysOperation.Me.exercise1.model;

import javaStart.task29_ArraysOperation.Me.exercise1.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1.exception.NoIndicatedPersonException;

import java.util.ArrayList;
import java.util.List;

public class PersonDatabase {
    private List<Person> people = new ArrayList<>();

    public List<Person> getPeople() {
        return people;
    }

    public void add(Person person) {
        checkDuplicate(person);
        people.add(person);
    }

    private void checkDuplicate(Person person) {
        for (Person p : people) {
            if (person.getId().equals(p.getId())) {
                throw new DuplicateException("Person already exists with that id");
            }
        }
    }

    public boolean remove(Person person) {
        boolean removeOk = false;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId().equals(person.getId())) {
                people.remove(person);
                removeOk = true;
            } else {
                throw new NoIndicatedPersonException("No indicated person");
            }
        }
        return removeOk;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(people.toString());
        return sb.toString();
    }
}
