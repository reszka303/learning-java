package webTechnologies.task7_lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestReplaceIfToStream {
    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "2", "4"};
//        System.out.println(Arrays.toString(numbers));

//        System.out.println(Arrays.toString(numbers));
//        int capacity = numbers.length;
//
//        List<String> stringList = new ArrayList<>();
//        for (int i = 0; i < capacity; i++) {
//            for (int j = i + 1; j < capacity; j++) {
//                if (numbers[i].equals(numbers[j])) {
//                    stringList.add(numbers[i]);
//                }
//            }
//        }
//
//        System.out.println("String List: " + stringList);


        List<Integer> integers = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("integers: " + integers);

//
//        List<Integer> distinctIntegers = integers.stream().distinct().collect(Collectors.toList());
//        System.out.println("distinct: " + distinctIntegers);
//
//        List<Integer> equalList = new ArrayList<>();
//        for (int i = 0; i < integers.size(); i++) {
//            for (int j = i + 1;  j < integers.size(); j++) {
//                if (integers.get(i).equals(integers.get(j))) {
//                    equalList.add(integers.get(i));
//                }
//            }
//        }
//
//        System.out.println("equal list: " + equalList);



//
//        List<String> stringList = Arrays.asList(numbers);


//        List<String> list1 = new ArrayList<String>();
//
//        list1.add("1");
//        list1.add("12");
//        list1.add("3");
//
//        List<String> list2= new ArrayList<String>();
//        list2.add("11");
//        list2.add("12");
//        list2.add("3");
//
//        List<String> list3 = new ArrayList<String>(list2);
//        list3.retainAll(list1);
//        System.out.println(list3);
    }
}
