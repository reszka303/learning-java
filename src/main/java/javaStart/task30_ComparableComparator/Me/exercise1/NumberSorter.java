package javaStart.task30_ComparableComparator.Me.exercise1;

import java.util.Arrays;
import java.util.Comparator;

public class NumberSorter {
    public static void main(String[] args) {

        Integer[] ints = {1, 5, 10, 19, 102,1098, 43, 25,1111, 36, 31, 99,
                9, 77, 7, 66, 6, 55, 44, 33,};

        System.out.println("Nieposortowane");
        System.out.println(Arrays.toString(ints));

        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("Posortowane rosnąco");
        System.out.println(Arrays.toString(ints));

        Arrays.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

        System.out.println("Posortowane malejąco");
        System.out.println(Arrays.toString(ints));
    }
}
