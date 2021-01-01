package javaStart.task35_Iterator.lesson;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PersonApp {

    public static void main(String[] args) {
        Map<String, Person> personMap = getMap();

        printLine("Foreach:");
        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            printLine("" + entry.getValue());
        }

        printLine("");

        printLine("Iterator:");
        Iterator<Map.Entry<String, Person>> entryIterator = personMap.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Person> entry = entryIterator.next();
            printLine("" + entry.getValue());
        }
    }

    private static Map<String, Person> getMap() {
        Map<String, Person> personMap = new TreeMap<>();

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
        personMap.put(marlonBrando.getFirstName(), marlonBrando);

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

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Person person = (Person) o;
//            return Objects.equals(lastName, person.lastName);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(lastName);
//        }

        @Override
        public String toString() {
            return  lastName + " " + firstName + " " + age;
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
