package javaStart.task30_ComparableComparator.Me.exercise2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PropertyControl {
    private final String fileName = "D:\\INNE\\Programowanie\\Projects\\learning\\city.txt";

    void run() {
        try {
            List<Property> properties = readFile();
            printProperty(properties);
        } catch (DataReadException e) {
            e.getMessage();
        }
    }

    private List<Property> readFile() {
        try {
            List<Property> properties = PropertyDataReader.readPropertiesFromTxt(fileName);
            return properties;
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + fileName);
        } catch (IOException e) {
            throw new DataReadException("Error file read " + fileName);
        }
    }

    private void printProperty(List<Property> properties) {
        Collections.sort(properties);
        printLine("Available real estates:");
        for (Property property : properties) {
            printLine(property.toString());
        }
    }

    private void printLine(String text) {
        System.out.println(text);
    }
}
