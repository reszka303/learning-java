package javaStart.task37_LambdaExpression.exercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NumberGenerator {
    public static void main(String[] args) {
        Supplier<Integer> supplier = randomNumber();
        List<Integer> integers = generateRandomList(10, supplier);
        printLine(">>> Integers:");
        consumeList(integers, integer -> printNoLine("" + integer+ " "));
        removeNumbers(integers, integer -> integer % 2 == 0);
        printLine("");
        printLine(">>>Integers without integers divided by 2");
        consumeList(integers, integer -> printNoLine("" + integer +" "));
    }

    private static Supplier<Integer> randomNumber() {
        Random random = new Random();
        Supplier<Integer> supplier = () -> {
            return random.nextInt(201) - 100;
        };
        return supplier;
    }

    private static <T> List<T> generateRandomList(int size, Supplier<T> supplier) {
        List<T> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            resultList.add(supplier.get());
        }
        return resultList;
    }

    private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    private static <T> void removeNumbers(List<T> list, Predicate<T> predicate) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.test(element)) {
                iterator.remove();
            }
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printNoLine(String text) {
        System.out.print(text);
    }
}
