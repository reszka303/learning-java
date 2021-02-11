package javaStart.task40_CollectionProcessing.exercise1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class WordControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private WordFileManager wordFileManager = new WordFileManager();
    private WordManager wordManager = new WordManager();
    private static final String fileName = "D:\\INNE\\Programowanie\\Projects\\learning\\loremIpsum.txt";

    void run() {
        try {
            List<String> words = readFile();
            printer.printLine("");
            printer.printList(words);
            printer.printLine("");
            String stats = wordManager.printStatsWord(words);
            printer.printLine(stats);
        } catch (DataReadException e) {
            e.getMessage();
        }
    }

    private List<String> readFile() {
        try {
            return wordFileManager.readFileFromCsv(fileName);
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + fileName);
        } catch (IOException e) {
            throw new DataReadException("Error data file" + fileName);
        }
    }
}
