package javaStart.task37_LambdaExpression.lesson.Function;

import java.util.function.Function;

public class FunctionFunctions {
    public static void main(String[] args) {
        Function<String, String> function = text -> text.toLowerCase().trim();
        String original = "   WIELKI NAPIS   ";
        String lowerCaseTrim = function.apply(original);
        System.out.println(lowerCaseTrim);
    }
}
