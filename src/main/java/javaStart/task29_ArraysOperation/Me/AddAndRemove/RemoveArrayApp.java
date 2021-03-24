package javaStart.task29_ArraysOperation.Me.AddAndRemove;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveArrayApp {
    private static int initialCapacity = 3;
    private static Person[] people = new Person[initialCapacity];

    public static void main(String[] args) {
        Instant start = Instant.now();
        people = create();
        print(people);
        printLine("");
        people = remove();
        print(people);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

    }

    private static Person[] remove() {
        List<Person> persons = new ArrayList<>(List.of(people));
        Iterator<Person> personIterator = persons.iterator();
        iterate(personIterator);
        return getPeople(persons);
    }

    private static void iterate(Iterator<Person> personIterator) {
        while (personIterator.hasNext()) {
            if (personIterator.next().getId() == 3) {
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

    private static Person[] create() {
        people[0] = new Person("Leonardo", "DiCaprio", 1);
        people[1] = new Person("David", "Cohen", 2);
        people[2] = new Person("Sylvester", "Stallone", 3);
        people[3] = new Person("Gregory", "Peck", 4);
        return people;
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
}
