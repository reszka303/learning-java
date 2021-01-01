package javaStart.task35_Iterator.lesson;

import java.util.*;

public class PersonApp {

    public static void main(String[] args) {
        Map<String, Person> personMap = getMap();

        printLine("Map.Entry in Foreach:");
        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            printLine("" + entry.getValue());
        }

        printLine("");

        printLine("Map.Entry in Iterator:");
        Iterator<Map.Entry<String, Person>> entryIterator = personMap.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Person> entry = entryIterator.next();
            printLine("" + entry.getValue());
        }

        printLine("");

        printLine("Collection in foreach");
        for (Person person : personMap.values()) {
            printLine("" + person.toString());
        }

        printLine("");

        printLine("Collection in Iterator");
        Collection<Person> values = personMap.values();
        Iterator<Person> personIterator = values.iterator();
        while (personIterator.hasNext()) {
            printLine(personIterator.next().toString());
        }
    }

    private static Map<String, Person> getMap() {

        Map<String, Person> personMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String lastName1, String lastName2) {
                return lastName1.compareTo(lastName2);
            }
        });

        Person gregoryPeck = new Person("Gregory", "Peck", 82);
        Person leonardoDiCaprio = new Person("Leonardo", "DiCaprio", 46);
        Person humphreyBogart = new Person("Humphrey", "Bogart", 36);
        Person caryGrant = new Person("Cary", "Grant", 39);
        Person gregoryPecks = new Person("Gregory", "Peck", 82);
        Person marlonBrando = new Person("Marlon", "Brando", 25);

        personMap.put(gregoryPeck.getLastName(), gregoryPeck);
        personMap.put(leonardoDiCaprio.getLastName(), leonardoDiCaprio);
        personMap.put(humphreyBogart.getLastName(), humphreyBogart);
        personMap.put(caryGrant.getLastName(), caryGrant);
        personMap.put(gregoryPecks.getLastName(), gregoryPecks);
        personMap.put(marlonBrando.getLastName(), marlonBrando);

        return personMap;
    }

    private static class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return  lastName + " " + firstName + " " + age;
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
