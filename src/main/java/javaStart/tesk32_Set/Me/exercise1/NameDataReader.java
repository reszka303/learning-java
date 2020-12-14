package javaStart.tesk32_Set.Me.exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class NameDataReader {
    private static final String COMMA_DELIMITER = ";";

    static TreeSet readNamesFromTxt(String fileName) throws IOException {
        TreeSet<Names> names = new TreeSet<>(new Comparator<Names>() {
            @Override
            public int compare(Names o1, Names o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });

        try (var br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] delimiter = line.split(COMMA_DELIMITER);
                Names name = createNamesFromTxt(delimiter);
                names.add(name);
            }
        }
        return names;
    }

    static Names createNamesFromTxt(String[]  data) {
        String name = data[0];

        return new Names(name);
    }
}
