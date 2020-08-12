package javaStart.task25_FileOperations.JS.Training;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    public static void main(String[] args) {
        String fileName = "testFile.txt";
        File file = new File(fileName);

        boolean fileExist = file.exists();
        if (!fileExist) {
            try {
                fileExist = file.createNewFile();
            } catch (IOException e) {
                System.out.println("A file hasn't been created");
            }
        }
        if (fileExist) {
            System.out.println("A file " + fileName +
                    " exist or has been created");
        }
    }
}
