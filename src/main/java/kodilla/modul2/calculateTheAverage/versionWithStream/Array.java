package kodilla.modul2.calculateTheAverage.versionWithStream;

import java.util.Arrays;

public class Array {
    private int[] array;

    public int[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
