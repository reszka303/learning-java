package javaStart.task29_ArraysOperation.Me.AddAndRemove;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    private static Scanner input = new Scanner(System.in);
    private static int initialCapacity = 0;
    private static Person[] people = new Person[initialCapacity];

    public static void main(String[] args) {
        Instant start = Instant.now();
        boolean peopleOK = false;
        while (!peopleOK) {
            try {
                printLine("Rozmiar tablicy przed dodaniem 1 osoby: " + people.length);
                people = add();
                printLine("Rozmiar tablicy po dodaniu 1 osoby: " + people.length);
                print(people);
            } catch (DuplicatePersonException e) {
                e.getMessage();
            }

            while (!peopleOK) {
                try {
                    printLine("Rozmiar tablicy przed dodaniem 2 osoby: " + people.length);
                    people = add();
                    printLine("Rozmiar tablicy po dodaniu 2 osoby: " + people.length);
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
        System.out.println(Duration.between(start, end));
    }

    private static Person[] remove() {
        List<Person> persons = new ArrayList<>(List.of(people));
        Person person = getId();
        Iterator<Person> personIterator = persons.iterator();
        iterate(person, personIterator);
        return getPeople(persons);
    }

    private static void iterate(Person person, Iterator<Person> personIterator) {
        while (personIterator.hasNext()) {
            if (personIterator.next().getId() == person.getId()) {
                personIterator.remove();
            }
        }
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

    private static void clearBuffer() {
        input.nextLine();
    }
}
