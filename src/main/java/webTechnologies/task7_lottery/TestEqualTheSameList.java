package webTechnologies.task7_lottery;

public class TestEqualTheSameList {
    public static void main(String[] args) {
        String[] numbers = {"1", "2", "3", "4", "2", "4"};
//        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        if (checkEqualElements(numbers)) {
            success();
        } else {
            failure();
        }
    }

    private static void success() {
        System.out.println("Dobrze wykonane");
    }

    private static void failure() {
        System.out.println("Źle wykonane");
    }

    private static boolean checkEqualElements(String[] numbers) {
        int capacity = numbers.length;
        for (int i = 0; i < capacity; i++) {
            for (int j = i + 1; j < capacity; j++) {
                if (numbers[i].equals(numbers[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
