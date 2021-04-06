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
            //wyniki meczów pierwsza runda
            resultsFirstRound(matchManager, writer);
            //rysowanie tabeli pierwsza runda
            writeTableFirstRound(matchManager, writer);
            //wyniki meczów mecze rewanżowe
            resultsRematches(matchManager, writer);
            //rysowanie tabeli mecze rewanżowe
            writeTableRematches(matchManager, writer);
            //rysowanie tabeli wszystkich meczów
            writeJoinedTableAllMatches(matchManager, writer);
//            liczenie zespołów
            countByTeams(matchManager, writer);
//            liczenie bramek
            countByGoals(matchManager, writer);
//            sortowanie od wygranych do przegranych pierwsza runda
            sortFromWinsToLosesByFirstRound(matchManager, writer);
            //sortowanie od wygranych do przegranych rewanże
            sortFromWinsToLosesByRematches(matchManager, writer);
//            sortowanie wszystkich meczów
            sortFromWinsToLosesByAllMatches(matchManager, writer);
//            mecze wybranego zespołu przez użytkownika wszystkie mecze
            sortByTeam(matchManager, writer);
        } catch (IOException e) {
            throw new DataWriteException("Data write error into file: " + FILE_NAME);
        }
    }

    private void sortByTeam(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.newLine();
        List<Match> firstRound = matchManager.getMatchFirstRound();
        List<Match> rematches = matchManager.getMatchRematch();
        List<Match> allMatches = matchManager.joinAllSortedMatchesByWinTiesLoss(firstRound, rematches);
        String team = matchManager.getTeam();
        firstRound = matchManager.sortByTeam(allMatches, team);
        writer.write("All matches of the following team: " + team);
        writer.newLine();
        writeList(writer, firstRound);
        writeDoubleNewLine(writer);
    }

    private void countByGoals(MatchManager matchManager, BufferedWriter writer) throws IOException {
        List<Match> matches = matchManager.getMatchFirstRound();
        long goalsNumber = matchManager.countByGoals(matches);
        writer.write("Number of goals in the competition by all rounds: " + goalsNumber);
        writeDoubleNewLine(writer);
    }

    private void countByTeams(MatchManager matchManager, BufferedWriter writer) throws IOException {
       List<String> teams = matchManager.getTeams();
        int teamsNumber = matchManager.countByTeams(teams);
        writer.write("Number of teams in the competition: " + teamsNumber);
        writeDoubleNewLine(writer);
    }

    private void writeTableFirstRound(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("The table of the results of first round:");
        writeDoubleNewLine(writer);
        List<Scoring> scoring = groupByFirstRound(matchManager);
        writer.write(printer.printStandingsShortcutsTable());
        scoring = matchManager.increasePosition(scoring);
        writeList(writer, scoring);
        writeDoubleNewLine(writer);
    }

    private void writeTableRematches(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("The table of the results of rematches:");
        writeDoubleNewLine(writer);
        List<Scoring> scoring = groupByRematches(matchManager);
        writer.write(printer.printStandingsShortcutsTable());
        scoring = matchManager.increasePosition(scoring);
        writeList(writer, scoring);
        writeDoubleNewLine(writer);
    }

    private void writeJoinedTableAllMatches(MatchManager matchManager, BufferedWriter writer) throws IOException {
        List<Scoring> scoringFirstRound = matchManager.getScoringFirstRound();
        List<Scoring> scoringRematches = matchManager.getScoringRematch();
        List<Scoring> allScoring = matchManager.joinFirstRoundAndRematches(scoringFirstRound, scoringRematches);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(allScoring);
        allScoring = matchManager.getKey(scoringListMap);
        allScoring = matchManager.sortByPointsAndGoals(allScoring);
        allScoring = matchManager.increasePosition(allScoring);
        writer.write("The table of the results of all matches");
        writeDoubleNewLine(writer);
        writeList(writer, allScoring);
        writeDoubleNewLine(writer);
    }

    private void sortFromWinsToLosesByFirstRound(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("Results sorted from win to loss by first round");
        writer.newLine();
        List<Match> matches = matchManager.getMatchFirstRound();
        matches = sortByScores(matchManager, matches);
        writeList(writer, matches);
        writeDoubleNewLine(writer);
    }

    private void sortFromWinsToLosesByRematches(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("Results sorted from win to loss by rematches");
        writer.newLine();
        List<Match> matches = matchManager.getMatchRematch();
        matches = sortByScores(matchManager, matches);
        writeList(writer, matches);
        writeDoubleNewLine(writer);
    }

    private void sortFromWinsToLosesByAllMatches(MatchManager matchManager, BufferedWriter writer) throws IOException {
        writer.write("Results sorted from win to loss by all matches");
        writer.newLine();
        List<Match> firstRound = matchManager.getMatchFirstRound();
        List<Match> rematches = matchManager.getMatchRematch();
        List<Match> allMatches = matchManager.joinAllSortedMatchesByWinTiesLoss(firstRound, rematches);
        allMatches = sortByScores(matchManager, allMatches);
        writeList(writer, allMatches);
        writeDoubleNewLine(writer);
    }

    private void resultsFirstRound(MatchManager matchManager, BufferedWriter writer) throws IOException {
        List<Match> matches = matchManager.getMatchFirstRound();
        writer.write("Results of first round:");
        writer.newLine();
        writeList(writer, matches);
        writeDoubleNewLine(writer);
    }

    private void resultsRematches(MatchManager matchManager, BufferedWriter writer) throws IOException {
        List<Match> matches = matchManager.getMatchRematch();
        writer.write("Results of rematches:");
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

    private List<Scoring> groupByFirstRound(MatchManager matchManager) {
        List<Scoring> scoring = matchManager.getScoringFirstRound();
        Map<Scoring, List<Scoring>> resultListMap = matchManager.groupByName(scoring);
        scoring = matchManager.getKey(resultListMap);
        return matchManager.sortByPointsAndGoals(scoring);
    }

    private List<Scoring> groupByRematches(MatchManager matchManager) {
        List<Scoring> scoring = matchManager.getScoringRematch();
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoring);
        scoring = matchManager.getKey(scoringListMap);
        return matchManager.sortByPointsAndGoals(scoring);
    }

    private List<Match> sortByScores(MatchManager matchManager, List<Match> matches) {
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
