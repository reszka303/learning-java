package differentTasks.Optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test1Optional {
    public static void main(String[] args) {
        int capacity = 5;
        String[] strings = new String[capacity];
        strings[5] = "kubełek5";

        Optional<String> string = getString(strings);
        List<String> collect = string.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static Optional <String> getString(String[] strings) {
        for (String string : strings) {
            if (string != null) {
                return Optional.of(string);
            }
        }
        return Optional.empty();
    }
}
