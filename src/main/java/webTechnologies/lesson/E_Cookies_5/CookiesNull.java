package webTechnologies.lesson.E_Cookies_5;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CookiesNull {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        String s = list.stream().filter(x -> x.length() == 1)
                .findFirst()
                .map(Object::toString)
                .orElse(null);

        System.out.println(s); // a

    }

    private static Optional <String> getString(String[] strings) {
        if (strings == null) {
            return Optional.empty();
        }
        for (String string : strings) {
            return Optional.of(string);
        }
        return Optional.empty();
    }
}
