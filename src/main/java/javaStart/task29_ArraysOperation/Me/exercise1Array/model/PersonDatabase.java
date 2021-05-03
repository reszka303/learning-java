package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.NumberNotFoundException;

public class PersonDatabase implements Database  {
    private final int initialCapacity = 0;
    private Person[] persons = new Person[initialCapacity];

    public Person[] getPersons() {
        return persons;
    }

    @Override
    public <T> T[] add(T t) {
        int capacity = persons.length;
        Person[] copyPersons = new Person[capacity + 1];
        for (int i = 0; i < persons.length; i++) {
            copyPersons[i] = persons[i];
        }
        copyPersons[capacity] = (Person) t;
        if (persons.length >= 1) {
            checkDuplicate((Person) t);
        }
        persons = copyPersons;
        return (T[]) persons;
    }

    private void checkDuplicate(Person person) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getId() == person.getId()) {
                throw new DuplicateException("There is already the person with the same id");
            }
        }
    }

    @Override
    public <T> T[] remove(int id) {
        int idVerify = checkId(id);
        checkIfException(idVerify);
        persons = removeLogic(id);
        return (T[]) persons;
    }

    private Person[] removeLogic(int id) {
        int size = persons.length;
        Person[] personsAfterRemoving = new Person[size - 1];
        for (int i = 0, k = 0; i < size; i++) {
            if (persons[i].getId() != id) {
                personsAfterRemoving[k] = persons[i];
                k++;
            }
        }
        return personsAfterRemoving;
    }

    private int checkId(int id) {
        int size = persons.length;
        int idVerify = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i].getId() == id) {
                idVerify++;
            }
        }
        return idVerify;
    }

    private int checkIfException(int idVerify) {
        if (idVerify == 0) {
            throw new NumberNotFoundException("There is not person with given id");
        }
        return idVerify;
    }
}
