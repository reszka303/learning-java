package javaStart.task37_LambdaExpression.lesson.operationsOnIntefaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PersonOperators {
    public static void main(String[] args) {
        String[] firstNames = {"Jan", "Karol", "Piotr", "Andrzej"};
        String[] lastNames = {"Abacki", "Kowalski", "Zalewski", "Korzeniewski"};
        int[] ages = {14, 17, 44, 55};
        Random random = new Random();
        Supplier<Person> supplier = () -> {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            int age = ages[random.nextInt(ages.length)];
            return new Person(firstName, lastName, age);
        };

        List<Person> people = generateRandomList(5, supplier);
//        people.add(new Person("Jan", "Kowalski", 42));
//        people.add(new Person("Kasia", "Kruczkowska", 22));
//        people.add(new Person("Piotr", "Adamiak", 15));
//        people.add(new Person("Jan", "Zawadzki", 17));
//        people.add(new Person("Krzysztof", "Wojtyniak", 16));
//        people.add(new Person("Agnieszka", "Zagumna", 18));
//        people.add(new Person("Basia", "Cyniczna", 28));

        //Consumer person -> void
        printLine(">>> People");
        consumeList(people, person -> printLine("" + person));
        printLine(">>> People + Age1");
        consumeList(people, person -> person.setAge(person.getAge() + 1));
        consumeList(people, person -> printLine("" + person));

        //Predicate person -> boolean
        printLine(">>>Adults");
        List<Person> adults = filterByPredicate(people, person -> person.getAge() >= 18);
        consumeList(adults, person -> printLine("" + person));
        printLine(">>>JanPeople");
        List<Person> janPeople = filterByPredicate(people, person -> "Jan".equals(person.getFirstName()));
        consumeList(janPeople, person -> printLine("" + person));

        //Function<T, R> T t -> R r
        printLine(">>>FirstNames");
        List<String> names = convertList(people, person -> person.getFirstName());
        consumeList(names, person -> printLine(person));
    }

    //Consumer T t -> void
    private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    //Predicate T t -> boolean
    private static <T> List<T> filterByPredicate(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t: list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    //Function <T, R> T t -> R r
    private static <T, R> List<R> convertList(List<T> list, Function<T, R> function) {
        List<R> resultList = new ArrayList<>();
        for (T t : list) {
           R result =  function.apply(t);
            resultList.add(result);
        }
        return resultList;
    }

    //Supplier () ->
    private static <T> List<T> generateRandomList(int elements, Supplier<T> supplier) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
