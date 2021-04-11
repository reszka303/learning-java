package javaStart.task39_Streams.exercise2.combined.app.test;

import javaStart.task39_Streams.exercise2.combined.exception.DataReadException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class T11ReadFileByStream {
    private static final String LA_LIGA = "D:\\INNE\\Programowanie\\Projects\\learning\\matches\\LaLiga.txt";
    public static void main(String[] args) {
        List<String> laLiga = laLiga();
        laLiga.forEach(System.out::println);
    }

    private static List<String> laLiga() {
        try (var reader = new BufferedReader(new FileReader(LA_LIGA))){
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + LA_LIGA);
        } catch (IOException e) {
            throw new DataReadException("Error data read file " + LA_LIGA);
        }
    }

}
