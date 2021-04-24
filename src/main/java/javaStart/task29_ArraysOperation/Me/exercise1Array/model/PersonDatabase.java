package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.DataReader;

public class PersonDatabase {
    private DataReader dataReader = new DataReader();
    private final int initialCapacity = 3;
    private Person[] persons = new Person[initialCapacity];

    public Person[] getPersons() {
        return persons;
    }

    public Person[] create() {
        persons[0] = new Person("Leonardo", "DiCaprio", 123);
        persons[1] = new Person("Sean", "Connery", 999);
        persons[2] = new Person("Sylvester", "Stallone", 345);
        return persons;
    }

    public Person[] addPerson(Person person) {
        int resize = persons.length;
        Person[] resizedPersons = new Person[resize + 1];
        for (int i = 0; i < resize; i++) {
            resizedPersons[i] = persons[i];
        }
        checkDuplicate(person);
        resizedPersons[resize] = person;
        return resizedPersons;
    }

    private void checkDuplicate(Person person) {
        for (int i = 0; i < persons.length; i++) {
            if (person.getId() == persons[i].getId()) {
                throw new DuplicateException("There is already the person with the same id");
            }
        }
    }

    public Person[] removePerson() {
        int size = persons.length;
        int id = dataReader.getIdToRemove();
        persons = toNull(size, id);
        persons = nullToLastIndex(size);
        persons = removeLastIndex(size);
        return persons;
    }

    private Person[] toNull(int size, int id) {
        Person[] newPersons = new Person[size];
        for (int i = 0; i < size; i++) {
            if (persons[i].getId() != id) {
                newPersons[i] = persons[i];
            }
        }
        return newPersons;
    }

    private Person[] nullToLastIndex(int size) {
        int index = 0;
        Person[] newPersons = new Person[size];
        for (int i = 0; i < size; i++) {
            if (persons[i] != null) {
                newPersons[index++] = persons[i];
            }
        }
        return newPersons;
    }

    private Person[] removeLastIndex(int size) {
        int decreasedByOne = size - 1;
        Person[] newPerson = new Person[decreasedByOne];
        for (int i = 0; i < decreasedByOne; i++) {
            newPerson[i] = persons[i];
        }
        return newPerson;
    }
}
