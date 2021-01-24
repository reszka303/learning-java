package javaStart.task37_LambdaExpression.lesson.Consumer;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerFunctions {
    public static void main(String[] args) {
        Function<String, String> function = text -> text.toLowerCase().trim();
        String original = "   WIELKI NAPIS   ";
        String changed = function.apply(original);
        System.out.println(changed);
        System.out.println();

        Consumer<String> print3Times = s -> {
            System.out.println(s);
            System.out.println(s);
            System.out.println(s);
        };
        print3Times.accept(changed);
    }
}
