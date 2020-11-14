package javaStart.task29_ArraysOperation.Me.Database;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "text.letter";

    @Override
    public void writeData(LetterDatabase letterDatabase) {
        try (var fileOutputStream = new FileOutputStream(FILE_NAME);
             var objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(letterDatabase);
        } catch (FileNotFoundException e) {
           throw new DataWriteException("File not found");
        } catch (IOException e) {
            throw new DataWriteException("Data write error");
        }
    }

    @Override
    public LetterDatabase readData() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (LetterDatabase) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataReadException("File not found");
        } catch (IOException e) {
            throw new DataReadException("Data file error");
        } catch (ClassNotFoundException e) {
            throw new DataReadException("Invalid data type");
        }
    }
}
