package javaStart.task39_Streams.lesson.IntroductionToStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStream {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/javaStart/task39_Streams/lesson/file"));
        scanner.tokens()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
