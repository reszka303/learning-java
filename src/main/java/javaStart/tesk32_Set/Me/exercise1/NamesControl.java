package javaStart.tesk32_Set.Me.exercise1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeSet;

public class NamesControl {
    private final String fileName = "D:\\INNE\\Programowanie\\Projects\\learning\\namespl.txt";

    void run() {
        try {
            TreeSet<Names> names = readFile(fileName);
            printNames(names);
            printLine(printStats(names));
        } catch (DataReadException e) {
            e.getMessage();
        }
    }

    private TreeSet<Names> readFile(String fileName) {
        try {
            TreeSet<Names> names = NameDataReader.readNamesFromTxt(fileName);
            return names;
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + fileName);
        } catch (IOException e) {
            throw new DataReadException("Error data file " + fileName);
        }
    }

    private void printNames(TreeSet<Names> names) {
        for (Names name : names) {
            printLine(name.toString());
        }
    }

    private String printStats(TreeSet<Names> names) {
        var sb = new StringBuilder();
        sb.append("There are the following numbers of names in the set: " + names.size());
        sb.append("\n");
        sb.append("The first name is: " + names.first());
        sb.append("\n");
        sb.append("The last name is: " + names.last());
        return sb.toString();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
