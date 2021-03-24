package javaStart.task29_ArraysOperation.Me.AddAndRemove;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddAndRemoveApp {
    private static Scanner input = new Scanner(System.in);
    private static int initialCapacity = 0;
    private static Person[] people = new Person[initialCapacity];

    public static void main(String[] args) {
        Instant start = Instant.now();
        boolean peopleOK = false;
        while (!peopleOK) {
            try {
                printLine("Array size before adding 1 person: " + people.length);
                people = add();
                printLine("Board size after adding 1 person: " + people.length);
                print(people);
            } catch (DuplicatePersonException e) {
                e.getMessage();
            }

            while (!peopleOK) {
                try {
                    printLine("Array size before adding 2 person: " + people.length);
                    people = add();
                    printLine("Board size after adding 2 person: " + people.length);
                    print(people);
                    peopleOK = true;
                } catch (DuplicatePersonException e) {
                    e.getMessage();
                }
            }
        }
        Person[] newPeople = remove();
        print(newPeople);
        Instant end = Instant.now();
        printLine("" + Duration.between(start, end));
    }

    private static Person[] remove() {
        List<Person> persons = new ArrayList<>(List.of(people));
        Person person = getId();
        Iterator<Person> personsIterator = getPersonToRemove(persons, person);
        return getPeople(persons);
    }

    private static Iterator<Person> getPersonToRemove(List<Person> persons, Person person) {
        int counter = 0;
        Iterator<Person> personIterator = persons.iterator();
        while (personIterator.hasNext()) {
            if (personIterator.next().getId() == person.getId()) {
                personIterator.remove();
                counter++;
            }
        }
        if (counter == 0) {
            printLineError("There is no person with given id: " + person.getId());
        }
        return personIterator;
    }

    private static Person[] getPeople(List<Person> persons) {
        Person[] newPeople = new Person[persons.size()];
        for (int i = 0; i < persons.size(); i++) {
            newPeople[i] = persons.get(i);
        }
        return newPeople;
    }

    private static Person[] add() {
        Person person = create();
        int resize = people.length;
        Person[] resizedPeople = new Person[resize + 1];
        for (int i = 0; i < resize; i++) {
            resizedPeople[i] = people[i];
        }
        checkDuplicate(person);
        resizedPeople[resize] = person;
        return resizedPeople;
    }

    private static void checkDuplicate(Person person) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() == person.getId()) {
                throw new DuplicatePersonException("There is person with given id, try again");
            }
        }
    }

    private static Person create() {
        printLine("Enter a firstname");
        String firstName = input.nextLine();
        printLine("Enter a lastname");
        String lastName = input.nextLine();
        printLine("Enter an id");
        int id = getInt();
        return new Person(firstName, lastName, id);
    }

    private static Person getId() {
        printLine("Enter person's id who you want to remove");
        int id = getInt();
        return new Person(id);
    }

    private static void print(Person[] people) {
        for (Person person : people) {
            printLine(person.toString());
        }
    }

    private static class Person {
        private String firstName;
        private String lastName;
        private int id;

        public Person(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public Person(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Firstname: " + firstName + " Lastname: " + lastName + " id: " + id;
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }

    private static class DuplicatePersonException extends RuntimeException {
        public DuplicatePersonException(String message) {
            printLineError(message);
        }
    }

    private static int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }
}
