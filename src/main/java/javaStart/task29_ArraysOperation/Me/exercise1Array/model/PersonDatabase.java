package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.DuplicateException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.exception.NumberNotFoundException;
import javaStart.task29_ArraysOperation.Me.exercise1Array.io.DataReader;

public class PersonDatabase  {
    private DataReader dataReader = new DataReader();
    private int initialCapacity = 0;
    private Person[] persons = new Person[initialCapacity];

    public Person[] getPersons() {
        return persons;
    }

    public Person[] add(Person person) {
        int capacity = persons.length;
        Person[] copyPersons = new Person[capacity + 1];
        for (int i = 0; i < persons.length; i++) {
            copyPersons[i] = persons[i];
        }
        copyPersons[capacity] = person;
        if (persons.length >= 1) {
            checkDuplicate(person);
        }
        persons = copyPersons;
        return persons;
    }

    private void checkDuplicate(Person person) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getId() == person.getId()) {
                throw new DuplicateException("There is already the person with the same id");
            }
        }
    }

    public Person[] remove(int id) {
        int idVerify = checkId(id);
        checkIfException(idVerify);
        persons = removeLogic(id);
        return persons;
    }

    public Person[] removeLogic(int id) {
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

    int checkId(int id) {
        int size = persons.length;
        int idVerify = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i].getId() == id) {
                idVerify++;
            }
        }
        return idVerify;
    }

    int checkIfException(int idVerify) {
        if (idVerify == 0) {
            throw new NumberNotFoundException("There is not person with given id");
        }
        return idVerify;
    }



    //    public <T> T[] add(T t) {
//        int capacity = persons.length;
//        Person[] copyPersons = new Person[capacity + 1];
//        for (int i = 0; i < capacity; i++) {
//            copyPersons[i] = persons[i];
//        }
//        copyPersons[capacity] = (Person) t;
//        if (persons.length >= 1) {
//            checkDuplicate((Person) t);
//        }
//        persons = copyPersons;
//        return (T[]) persons;
//    }

//    @Override
//    public <T> T[] remove(int id) {
//        int capacity = persons.length;
//        Person[] copyPersons = new Person[capacity -1];
//        int verifyId = checkId(id);
//        checkIfException(verifyId);
//        copyPersons = (Person[]) persons = removeLogic(verifyId);
//
//    }
//
//    private Person[] removeLogic(int verifyId) {
//        int capacity = persons.length;
//        Person[] personsAfterRemoving = new Person[capacity - 1];
//        for (int i = 0, j = 0; i < capacity; i++) {
//            if (persons[i].getId() != verifyId) {
//                personsAfterRemoving[j] = persons[i];
//                j++;
//            }
//        }
//        return personsAfterRemoving;
//    }
}
