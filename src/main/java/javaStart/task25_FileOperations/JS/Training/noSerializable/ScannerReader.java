package javaStart.task25_FileOperations.JS.Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReader {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "testFile.txt";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        int lines = 0;

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            lines++;
            System.out.println(name);
        }
        System.out.println("The number lines in the file is: " + lines);
        scanner.close();
    }
}
