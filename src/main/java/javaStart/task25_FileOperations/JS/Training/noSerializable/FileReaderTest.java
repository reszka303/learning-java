package javaStart.task25_FileOperations.JS.Training;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Mateusz\\Desktop\\Pologne.txt");
        String fileName = "C:\\Users\\Mateusz\\Desktop\\Pologne.txt";


        try (
                var fileReader = new FileReader(file);
                var bufferedReader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            int lines = 0;

            while ((nextLine = bufferedReader.readLine()) != null) {
                System.out.println(nextLine);
                lines++;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
