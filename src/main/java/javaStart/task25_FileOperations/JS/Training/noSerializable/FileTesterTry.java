package javaStart.task25_FileOperations.JS.Training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileTesterTry {
    public static void main(String[] args) {
     String fileName = "testFile.txt";

        try (
             var fileReader = new FileReader(fileName);
             var bufferedReader = new BufferedReader(fileReader);
        ){
            String nextLine = null;
            int lines = 0;
            while ((nextLine = bufferedReader.readLine()) != null) {
                System.out.println(nextLine);
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
