package javaStart.task39_Streams.exercise2.combined.io.file;

import javaStart.task39_Streams.exercise2.combined.exception.DataReadException;
import javaStart.task39_Streams.exercise2.combined.exception.DataWriteException;
import javaStart.task39_Streams.exercise2.combined.io.ConsolePrinter;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;
import javaStart.task39_Streams.exercise2.combined.model.Match;
import javaStart.task39_Streams.exercise2.combined.model.MatchManager;
import javaStart.task39_Streams.exercise2.combined.model.Scoring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvFileManager {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private static final String FILE_NAME = "D:\\INNE\\Programowanie\\Projects\\learning\\matches.txt";

    public void readFile() {
        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
//                    printer.printLine(line);
                }
        } catch (FileNotFoundException e) {
            throw new DataReadException("No file: " + FILE_NAME);
        } catch (IOException e) {
            throw new DataReadException("Error read file: " + FILE_NAME);
        }
    }

    public void writeFile(MatchManager matchManager) {
        try (var writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            //podane zespoły
            givenTeams(matchManager, writer);
            //wyniki meczów
            matchesResults(matchManager, writer);
            //sortowanie od wygranych do przegranych
            sortByWinsToLoses(matchManager, writer);
            //rysowanie tabeli
            writeTable(matchManager, writer);
            //liczenie zespołów
            countByTeams(matchManager, writer);
            //liczenie bramek
            countByGoals(matchManager, writer);
            //mecze wybranego zespołu przez użytkownika
            sortByTeam(matchManager, writer);
        } catch (IOException e) {
            throw new DataWriteException("Data write error into file: " + FILE_NAME);
        }
    }

    private void sortByTeam(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("All matches of the selected team");
        writer.newLine();
        List<Match> matches = matchManager.getMatchFirstRound();
        String team = matchManager.getTeam();
        matches = matchManager.sortByTeam(matches, team);
        writeList(writer, matches);
        writeDoubleNewLine(writer);
    }

    private void countByGoals(MatchManager matchManager, BufferedWriter writer) throws IOException {
        List<Match> matches = matchManager.getMatchFirstRound();
        long goalsNumber = matchManager.countByGoals(matches);
        writer.write("Number of goals in the competition: " + goalsNumber);
        writeDoubleNewLine(writer);
    }

    private void countByTeams(MatchManager matchManager, BufferedWriter writer) throws IOException {
//        Map<Scoring, List<Scoring>> resultListMap = matchManager.getScoringFirstRoundListMap();
//        long teamsNumber = matchManager.countByTeams(resultListMap);
//        writer.write("Number of teams in the competition: " + teamsNumber);
//        writeDoubleNewLine(writer);
    }

    private void writeTable(MatchManager matchManager, BufferedWriter writer) throws IOException {
//        writer.write("The table of the results:");
//        writer.newLine();
//        List<Scoring> scorings = group(matchManager);
//        writer.newLine();
//        writer.write(printer.printStandingsShortcutsTable());
//        scorings = matchManager.increasePosition(scorings);
//        writeList(writer, scorings);
//        writeDoubleNewLine(writer);
    }

    private void sortByWinsToLoses(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("Results sorted by win to loss");
        writer.newLine();
        List<Match> sortedMatches = sortByScores(matchManager);
        writeList(writer, sortedMatches);
        writeDoubleNewLine(writer);
    }

    private void matchesResults(MatchManager matchManager, BufferedWriter writer) throws IOException {
        List<Match> matches = matchManager.getMatchFirstRound();
        writer.write("Results:");
        writer.newLine();
        writeList(writer, matches);
        writeDoubleNewLine(writer);
    }

    private void givenTeams(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("Teams taking part in the competition:");
        writer.newLine();
        writeTeams(matchManager, writer);
        writeDoubleNewLine(writer);
    }

    private <T> void writeList(BufferedWriter writer, List<T> list) throws IOException {
        String collect = list.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
        writer.write(collect);
    }

//    private List<Scoring> group(MatchManager matchManager) {
//        List<Scoring> scorings = matchManager.getScoringFirstRound();
//        Map<Scoring, List<Scoring>> resultListMap = matchManager.groupByName(scorings);
//        scorings = matchManager.getKey(resultListMap);
//        return matchManager.sortByPointsAndGoals(scorings);
//    }

    private List<Match> sortByScores(MatchManager matchManager) {
        List<Match> matches = matchManager.getMatchFirstRound();
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(matches);
        List<Match> ties = matchManager.sortByTies(matches);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(matches);
        return matchManager.joinWinTieLoss(winnersHome, ties, winnersAway);
    }

    private void writeTeams(MatchManager matchManager, BufferedWriter writer) throws IOException {
        List<String> teams = matchManager.getTeams();
        teams = upperLowerCase(teams);
        String collect = join(teams);
        writer.write(collect);
    }

    private List<String> upperLowerCase(List<String> list) {
        List<String> teams = new ArrayList<>();
        for (String str : list) {
            teams.add(dataReader.capitalizeFirstLetterEverySingleWord(str));
        }
        return teams;
    }

    private String join(List<String> teams) {
        return String.join(", ", teams);
    }

    private void writeDoubleNewLine(BufferedWriter writer) throws IOException {
        writer.newLine();
        writer.newLine();
    }
}