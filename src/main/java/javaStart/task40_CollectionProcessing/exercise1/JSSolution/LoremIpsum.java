package javaStart.task40_CollectionProcessing.exercise1.JSSolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoremIpsum {
    public static void main(String[] args) {
        final String fileName = "D:\\INNE\\Programowanie\\Projects\\learning\\loremIpsum.txt";

        List<String> words;
        try {
            words = readFile(fileName);
            showWordStats(words);
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku " + fileName);
        }
    }

    private static void showWordStats(List<String> words) {
        long countSWords = words.stream()
                .filter(s -> s.startsWith("s"))
//                .peek(System.out::println)
                .count();

        long fiveLetters = words.stream()
                .filter(s -> s.length() == 5)
                .peek(System.out::println)
                .count();

        for (String word : words) {
//            System.out.println(word);
        }
        System.out.println("Liczba wyrazów na 's': " + countSWords);
        System.out.println("Liczba wyrazów z 5 znakami: " + fiveLetters);
    }

    private static List<String> readFile(String fileName) throws IOException {
        try(var reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines() //Stream<String>
                    .map(line -> line.split(" ")) //Stream<String[]>
                    .flatMap(Arrays::stream) //Stream<String>
                    .map(s -> s.replaceAll(",", "").replaceAll("\\.", "")) //Stream<String>
                    .collect(Collectors.toList());
        }
    }
}
