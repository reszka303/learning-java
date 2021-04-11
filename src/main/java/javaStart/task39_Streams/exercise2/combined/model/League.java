package javaStart.task39_Streams.exercise2.combined.model;

import javaStart.task39_Streams.exercise2.combined.exception.DataReadException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class League implements Division  {
    private static final String LA_LIGA = "D:\\INNE\\Programowanie\\Projects\\learning\\matches\\LaLiga.txt";
    private static final String PREMIER_LEAGUE = "D:\\INNE\\Programowanie\\Projects\\learning\\matches" +
            "\\PremierLeague.txt";

    @Override
    public List<String> laLiga() {
        try (var reader = new BufferedReader(new FileReader(LA_LIGA))){
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + LA_LIGA);
        } catch (IOException e) {
            throw new DataReadException("Error data read file " + LA_LIGA);
        }
    }

    @Override
    public List<String> premierLeague() {
        try (final var reader = new BufferedReader(new FileReader(PREMIER_LEAGUE))){
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file " + PREMIER_LEAGUE);
        } catch (IOException e) {
            throw new DataReadException("Error data read " + PREMIER_LEAGUE);
        }
    }
}
