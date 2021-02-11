package javaStart.task40_CollectionProcessing.exercise1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class WordFileManager {
    private static final String DELIMITER = " ";

    List<String> readFileFromCsv(String file) throws IOException {
        try (var reader = new BufferedReader(new FileReader(file));
        ){
            return reader.lines()
                    .map(WordFileManager::splitText)
                    .flatMap(Arrays::stream)
                    .map(WordFileManager::removeCommaAndDot)
                    .collect(Collectors.toList());
        }
    }

    private static String removeCommaAndDot(String s) {
        return s.replaceAll(",", " ").replaceAll("\\.", " ");
    }

    private static String[] splitText(String line) {
        return line.split(DELIMITER);
    }
}
