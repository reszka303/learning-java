package javaStart.task29_ArraysOperation.Me.AddAndRemove;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class RemoveApp {
    private static Scanner input = new Scanner(System.in);
    private static int initialCapacity = 4;
    private static Person[] people = new Person[initialCapacity];

    public static void main(String[] args) {

        Instant start = Instant.now();
        people = create();
        print(people);
//        people = remove();
        Person[] newPeople = removeToNull();
        printLine(Arrays.toString(newPeople));
        Person[] sortPeople = sortNullToEnd(newPeople);
        printLine(Arrays.toString(sortPeople));
        Person[] peopleRemove = removeLastIndex(sortPeople);
        printLine(Arrays.toString(peopleRemove));
        print(peopleRemove);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    private static Person[] removeToNull() {
        int newPeopleSize = people.length;
        Person[] newPeople = new Person[newPeopleSize];
        Person person = getId();
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() != person.getId()) {
                newPeople[i] = people[i];
            }
        }
        return newPeople;
    }

    private static Person[] sortNullToEnd(Person[] people) {
        int newPeopleSize = people.length;
        Person[] newPeople = new Person[newPeopleSize];
        int index = 0;
        for (int i = 0; i < newPeopleSize; i++) {
            if (people[i] != null) {
                newPeople[index++] = people[i];
            }
        }
        return newPeople;
    }

    private static Person[] removeLastIndex(Person[] people) {
        int sizeNewPeople = people.length - 1;
        Person[] newPeople = new Person[sizeNewPeople];
        for (int i = 0; i < sizeNewPeople; i++) {
            newPeople[i] = people[i];
        }
        return newPeople;
    }

//    private static Person[] add() {
//        int resize = people.length;
//        Person[] resizedPeople = new Person[resize + 1];
//        for (int i = 0; i < resize; i++) {
//            resizedPeople[i] = people[i];
//        }
//        resizedPeople[resize] = person;
//        return resizedPeople;
//    }

    private static Person[] remove() {
        List<Person> persons = new ArrayList<>(List.of(people));
        Person person = getId();
        Iterator<Person> personIterator = persons.iterator();
        iterate(person, personIterator);
        return getPeople(persons);
    }

    private static Person[] getPeople(List<Person> persons) {
        Person[] newPeople = new Person[persons.size()];
        for (int i = 0; i < persons.size(); i++) {
            newPeople[i] = persons.get(i);
        }
        return newPeople;
    }

    private static void iterate(Person person, Iterator<Person> personIterator) {
        while (personIterator.hasNext()) {
            if (personIterator.next().getId() == person.getId()) {
                personIterator.remove();
            }
        }
    }

    private static Person getId() {
        printLine("Enter person's id who you want to remove");
        int id = getInt();
        return new Person(id);
    }

    private static Person[] create() {
        people[0] = new Person("Leonardo", "DiCaprio", 10);
        people[1] = new Person("David", "Cohen", 11);
        people[2] = new Person("Sylvester", "Stallone", 12);
        people[3] = new Person("Gregory", "Peck", 13);
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
            return "Name: " + firstName + ", Surname: " + lastName + ", Id: " + id;
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static int getInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }
}
