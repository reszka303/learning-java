package javaStart.task39_Streams.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(7);

        System.out.println(list);
        list.sort(Test::compare);
        System.out.println(list);


        List<Person> person = new ArrayList<>();
        person.add(new Person("Leonardo", 32));
        person.add(new Person("Gregory", 45));
        person.add(new Person("Tom", 15));
        person.add(new Person("Jimmy", 53));

        System.out.println(person);

        person.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println(person);
    }

    private static int compare(Integer c1, Integer c2) {
        return -Integer.compare(c1, c2);
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " " + age;
        }
    }
}
