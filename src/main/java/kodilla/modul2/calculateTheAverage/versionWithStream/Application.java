package kodilla.modul2.calculateTheAverage.versionWithStream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Array array = new Array();
        ArrayRandomRange randomRange = new ArrayRandomRange();
        randomRange.settingTheRandomRange(array.getArray());

        List<Object> numbers =  new Random().ints(0,100).limit(20).boxed().collect(Collectors.toList());
        System.out.println(numbers);

    }
}
