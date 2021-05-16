package javaStart.task29_ArraysOperation.Me.exercise1Array.io.file;

import javaStart.task29_ArraysOperation.Me.exercise1Array.model.DatabaseManager;

public interface FileManager {
    <T> T read();
    <T> void write(T t);
//    DatabaseManager read();
//    void write(DatabaseManager databaseManager);
}
