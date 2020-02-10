package kodilla.modul2.calculateTheAverage.versionWithStream;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayRandomRange {
    public void settingTheRandomRange(int[] array) {
        array = ThreadLocalRandom.current().ints(1,100).limit(20).toArray();
    }


}
