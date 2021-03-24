package javaStart.task29_ArraysOperation.Me.AddAndRemove;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveArrayListApp {
    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Instant start = Instant.now();
        people = create();
        people.forEach(System.out::println);
        printLine("");
        people = remove();
        people.forEach(System.out::println);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

    }

    private static List<Person> remove() {
        Iterator<Person> personIterator = people.iterator();
        iterate(personIterator);
        return people;
    }

    private static void iterate(Iterator<Person> personIterator) {
        while (personIterator.hasNext()) {
            if (personIterator.next().getId() == 3) {
                personIterator.remove();
            }
        }
    }

    private static List<Person> create() {
        people.add(new Person("Leonardo", "DiCaprio", 1));
        people.add(new Person("David", "Cohen", 2));
        people.add(new Person("Sylvester", "Stallone", 3));
        people.add(new Person("Gregory", "Peck", 4));
        return people;
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
