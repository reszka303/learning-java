package javaStart.task28_GenericTypes.Me.exercise1;

public class PairTest {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Emily", 1996);
        Pair<Double, Integer> pair2 = new Pair<>(3.9, 2001);
        Pair<String, String> pair3 = new Pair<>("Emily", "White");
        Pair<Character, Boolean> pair4 = new Pair<>('W', true);

        printPair(pair1);
        printPair(pair2);
        printPair(pair3);
        printPair(pair4);
    }

    private static <T, V>void printPair(Pair<T, V> pair) {
        printLine(pair.toString());
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
