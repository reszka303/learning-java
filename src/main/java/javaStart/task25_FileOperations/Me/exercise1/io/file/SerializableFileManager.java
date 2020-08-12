package javaStart.task25_FileOperations.Me.exercise1.io.file;

import javaStart.task25_FileOperations.Me.exercise1.exception.DataImportException;
import javaStart.task25_FileOperations.Me.exercise1.io.ConsolePrinter;
import javaStart.task25_FileOperations.Me.exercise1.model.Company;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "FileOperationTask1.o";
    private ConsolePrinter printer = new ConsolePrinter();

    @Override
    public void exportData(Company company) {
        try (var fileOutputStream = new FileOutputStream(FILE_NAME);
             var objectOutputStream= new ObjectOutputStream(fileOutputStream);
        ){
                objectOutputStream.writeObject(company);
                printer.printLine("Data has been written to a file");
        } catch (IOException e) {
            printer.printLineError("File write error");
        }
    }

    @Override
    public Company importData() {
        try (var fileInputStream = new FileInputStream(FILE_NAME);
             var objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return (Company) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("File reading error " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Incompatible data type in the file " + FILE_NAME);
        }
    }
}
