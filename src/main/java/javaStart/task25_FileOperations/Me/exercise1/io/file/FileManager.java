package javaStart.task25_FileOperations.Me.exercise1.io.file;

import javaStart.task25_FileOperations.Me.exercise1.model.Company;

public interface FileManager {
    Company importData();
    void exportData(Company company);
}
