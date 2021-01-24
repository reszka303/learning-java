package javaStart.task37_LambdaExpression.lesson.Predicate;

import java.util.function.Predicate;

public class PredicateFunctions {
    public static void main(String[] args) {
        int personAge = 19;
        Predicate<Integer> checkIfAdult = age -> age >= 18;
        boolean age = checkIfAdult.test(personAge);
        System.out.println(age);
    }
}
