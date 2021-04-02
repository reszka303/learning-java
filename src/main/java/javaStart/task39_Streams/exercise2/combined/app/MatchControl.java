package javaStart.task39_Streams.exercise2.combined.app;

import javaStart.task39_Streams.exercise2.combined.exception.DataReadException;
import javaStart.task39_Streams.exercise2.combined.exception.DataWriteException;
import javaStart.task39_Streams.exercise2.combined.io.ConsolePrinter;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;
import javaStart.task39_Streams.exercise2.combined.io.file.CsvFileManager;
import javaStart.task39_Streams.exercise2.combined.model.Match;
import javaStart.task39_Streams.exercise2.combined.model.MatchManager;
import javaStart.task39_Streams.exercise2.combined.model.Result;


import java.util.List;
import java.util.Map;

public class MatchControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private MatchManager matchManager = new MatchManager();
    private CsvFileManager csvFileManager = new CsvFileManager();

    public void run() {
        try {
            csvFileManager.readFile();
        } catch (DataReadException e) {
            e.getMessage();
            printer.printLine("The new database has been initiated");
            //pomyśleć co z drużynami dwuczłonowymi w drugim słowie są małe litery!!
        }
        addTeams();
        printer.printLine("");
        printResultsGivenTeams();
        printer.printLine("");
        group();
        printer.printLine("Table of matches: ");
        printTable();
        printer.printLine("");
        printer.printLine("Sort by matches from wins to loses");
        sortByScores();
        printer.printLine("");
        printer.printLine("Sort by matches with one team");
        sortByTeam();
        printer.printLine("");
        printer.printLine("Counting by teams");
        countByTeams();
        printer.printLine("");
        printer.printLine("Counting by goals");
        countByGoals();
        try {
            csvFileManager.writeFile(matchManager);
            printer.printLine("Data write into file has been finished successfully");
        } catch (DataWriteException e) {
            e.getMessage();
        }
        printer.printLine("Match manager has finished its work");
    }

    private void addTeams() {
        int number = dataReader.numbersTeams();
        List<String> teams = matchManager.addTeams(number);
        printer.printInfoAboutAddedTeams(teams);
        printer.printTeams(teams);
        printer.printLine("");
    }

    private void printResultsGivenTeams() {
        List<String> teams = matchManager.getTeams();
        printer.printLine("Added teams are the following:");
        teams.forEach(System.out::println);
        List<Match> matches = matchManager.createScores(teams);
        List<Result> results = matchManager.getScores(matches, teams);
        matches.forEach(System.out::println);
        printer.printLine("");
        results.forEach(System.out::println);
    }

    private void group() {
        List<Result> results = matchManager.getResults();
        Map<Result, List<Result>> resultListMap = matchManager.groupByName(results);
        printer.printMap(resultListMap);
    }

    private void printTable() {
        Map<Result, List<Result>> resultListMap = matchManager.getResultListMap();
        printer.printLine("");
        printer.printLine("Print Map<Result, List<Result>> resultListMap");
        printer.printMap(resultListMap);
        List<Result> results = matchManager.getKey(resultListMap);
        results = matchManager.sortByPointsAndGoals(results);
        printer.printLine("");
        printer.printLine("Print List<Result> results");
        printer.printLine("Sorting:");
        printer.printStandingsShortcuts();
        results = matchManager.increasePosition(results);
//        matchManager.increasePlaceStream(results);
        results.forEach(System.out::println);
    }

    private void sortByScores() {
        List<Match> matches = matchManager.getMatches();
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(matches);
        List<Match> ties = matchManager.sortByTies(matches);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(matches);
        matches = matchManager.combineLists(winnersHome, ties, winnersAway);
        matches.forEach(System.out::println);
    }

    private List<Match> sortByTeam() {
        List<String> teams = matchManager.getTeams();
        List<Match> matches = matchManager.getMatches();
        String team = matchManager.getTeam(teams);
        matches = matchManager.sortByTeam(matches, team);
        printer.printLine("All matches one team");
        matches.forEach(System.out::println);
        return matches;
    }

    private void countByTeams() {
        Map<Result, List<Result>> results = matchManager.getResultListMap();
        long numberTeams = matchManager.countByTeams(results);
        printer.printLine("The team numbers is: " + numberTeams);
    }

    private void countByGoals() {
        List<Match> matches = matchManager.getMatches();
        long numberGoals = matchManager.countByGoals(matches);
        printer.printLine("The goal numbers is: " + numberGoals);
    }
}
