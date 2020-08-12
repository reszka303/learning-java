package javaStart.task25_FileOperations.JS.Training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileTester {
    public static void main(String[] args) {
        String fileName = "testFile.txt";
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
                lines++;
            }
            System.out.println("Ilość wierszy w pliku: " + lines);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
