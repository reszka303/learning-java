package javaStart.task25_FileOperations.JS.Training.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriter {
    public static void main(String[] args) {
        String fileName = "person.obj";
        Person person1 = new Person("Jan", "Kowalski");

        try (var fileOutputStream = new FileOutputStream(fileName);
             var objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(person1);
            System.out.println("Object has been saved to a file");
        } catch (IOException e) {
            System.err.println("File write error");
            e.printStackTrace();
        }
    }
}
