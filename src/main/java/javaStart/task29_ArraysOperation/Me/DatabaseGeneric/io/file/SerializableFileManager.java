package javaStart.task29_ArraysOperation.Me.DatabaseGeneric.io.file;

import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.DataReadException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.exception.DataWriteException;
import javaStart.task29_ArraysOperation.Me.DatabaseGeneric.model.ItemDatabase;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private final String fileName = "GenericDatabase.file";

    @Override
    public void write(ItemDatabase itemDatabase) {
        try (var fos = new FileOutputStream(fileName);
             var oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(itemDatabase);
        } catch (FileNotFoundException e) {
            throw new DataWriteException("File not found " + fileName);
        } catch (IOException e) {
            throw new DataWriteException("Error data write " + fileName);
        }
    }

    @Override
    public ItemDatabase read() {
        try (var fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ){
           return (ItemDatabase) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataReadException("File not found " + fileName);
        } catch (IOException e) {
            throw new DataReadException("Error data read " + fileName);
        } catch (ClassNotFoundException e) {
            throw new DataReadException("Incorrect data type in the file " + fileName);
        }
    }
}
