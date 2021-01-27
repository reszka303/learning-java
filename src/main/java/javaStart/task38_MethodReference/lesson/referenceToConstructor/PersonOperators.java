package javaStart.task38_MethodReference.lesson.referenceToConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PersonOperators {
    private static String[] firstNames = {"Jan", "Karol", "Piotr", "Andrzej"};
    private static String[] lastNames = {"Abacki", "Kowalski", "Zalewski", "Korzeniewski"};
    private static int[] ages = {22, 33, 44, 55};

    public static void main(String[] args) {
        Supplier<Person> supplierNoParameters = Person::new;
        PersonSupplier supplier = Person::new;

        System.out.println(supplierNoParameters.get());
        System.out.println(supplier.get(firstNames, lastNames, ages));
//        List<Person> people = generateRandomList(5, supplier);
//        consumeList(people, System.out::println);
    }

    private static List<Person> generateRandomList(int elements, PersonSupplier supplier) {
        List<Person> result = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            result.add(supplier.get(firstNames, lastNames, ages));
        }
        return result;
    }

    private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
