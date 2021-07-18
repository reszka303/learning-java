package webTechnologies.task6_passwordValidator;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Zadanie sprawdza czy w danym Stringu znajduje się jakaś cyfra.
//W zadaniu wykorzystano interfejsy funkcyjne predicate oraz consumer
public class Test {
    public static void main(String[] args) {
        String password = "eboc1ie";
        boolean digit = isDigit(password);
        consume(digit, System.out::println);
    }

    private static boolean isDigit(String password) {
        return checkConditionForAllLetters(password, Character::isDigit);
    }

    private static boolean checkConditionForAllLetters(String password, Predicate<Character> predicate) {
        char[] chars = password.toCharArray();
        for (char ch : chars) {
            if (predicate.test(ch)) {
                return true;
            }
        }
        return false;
    }

    private static void consume(boolean character, Consumer<Boolean> consumer) {
        consumer.accept(character);
    }
}
