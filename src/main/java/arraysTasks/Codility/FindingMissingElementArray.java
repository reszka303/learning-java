package arraysTasks.Codility;

public class FindingMissingElementArray {

//    private static final int[] ints = new int[]{1,2,3,5,4,1};
    private static final int[] ints = new int[]{1,2,4,2};

    public static void main(String[] args) {
        int solution = solution(ints);
        System.out.println(solution);
    }

    public static int solution(int[] A) {
        boolean[] existingNumbers = new boolean[100_001];
        for (int i : A) {
            if (i >= 1 && i <= 100_001) {
                existingNumbers[i - 1] = true;
            }
        }
        for (int i = 0; i < existingNumbers.length; i++) {
            if (!existingNumbers[i]) {
                return i + 1;
            }
        }
        return 1;
    }

}
