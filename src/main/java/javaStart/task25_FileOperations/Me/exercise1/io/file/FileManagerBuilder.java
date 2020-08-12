package javaStart.task25_FileOperations.Me.exercise1.io.file;

import javaStart.task25_FileOperations.Me.exercise1.io.ConsolePrinter;
import javaStart.task25_FileOperations.Me.exercise1.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader dataReader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader dataReader) {
        this.printer = printer;
        this.dataReader = dataReader;
    }

    public FileManager build() {
        return new SerializableFileManager();
    }
}
