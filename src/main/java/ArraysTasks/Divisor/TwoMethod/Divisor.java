package ArraysTasks.Divisor.TwoMethod;

public class Divisor {
    protected String[] getDivisor(int number) {
        if (number == 0) {
            System.out.println("Libcza 0 ma nieskończenie wiele dzielników");
        } if (number < 0) {
            return calculateNegativeDivisor(number);
        } else {
            return calculatePositiveDivisor(number);
        }
    }

    protected String[] calculateNegativeDivisor(int number) {
        int capacityArray = arrayLengthNegativeNumber(number);
        int[] arrayInt = new int[capacityArray];
        for (int i = number, k = 0; i < capacityArray; i++) {
            if (i == 0) {
                continue;
            }
            if (number % i == 0) {
                arrayInt[k++] = i;
            }
        }
        int counter = setLengthArrayCopy(capacityArray, arrayInt);
        int[] copyArray = assignValueIntoCopyArray(capacityArray, arrayInt, counter);
        return toStringArray(copyArray);
    }

    private int[] assignValueIntoCopyArray(int capacityArray, int[] arrayInt, int counter) {
        int[] copyArray = new int[counter];
        for (int i = 0; i < capacityArray; i++) {
            if (arrayInt[i] != 0) {
                copyArray[i] = arrayInt[i];
            }
        }
        return copyArray;
    }

    private int setLengthArrayCopy(int capacityArray, int[] arrayInt) {
        int counter = 0;
        for (int i = 0; i < capacityArray; i++) {
            if (arrayInt[i] != 0) {
                counter++;
            }
        }
        return counter;
    }

    int arrayLengthNegativeNumber(int number) {
        int capacityArray = 0;
        for (int i = number; i < 0; i++) {
            capacityArray++;
        }
        int finalCapacityArray = 0;
        for (int i = number; i <= capacityArray; i++) {
            finalCapacityArray++;
        }
        return finalCapacityArray;
    }

    private String[] calculatePositiveDivisor(int number) {
        int capacityArray = arrayLengthPositiveNumber(number);
        int[] arrayInt = new int[capacityArray];
        for (int i = 1, k = 0; i < number + 1; i++) {
            if (number % i == 0) {
                arrayInt[k++] = i;
            }
        }
        return toStringArray(arrayInt);
    }

    private int arrayLengthPositiveNumber(int number) {
        int capacityArray = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                capacityArray++;
            }
        }
        return capacityArray;
    }

    private String[] toStringArray(int[] copyArray) {
        int capacityCopyArray = copyArray.length;
        String[] arrayString = new String[capacityCopyArray];
        for (int i = 0; i < capacityCopyArray; i++) {
            arrayString[i] = String.valueOf(copyArray[i]);
        }
        return arrayString;
    }
}
