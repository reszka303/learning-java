package javaStart.task39_Streams.exercise2.combined.app;

import javaStart.task39_Streams.exercise2.combined.io.ConsolePrinter;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;
import javaStart.task39_Streams.exercise2.combined.io.file.CsvFileManager;
import javaStart.task39_Streams.exercise2.combined.model.Match;
import javaStart.task39_Streams.exercise2.combined.model.MatchManager;
import javaStart.task39_Streams.exercise2.combined.model.Scoring;


import java.util.List;
import java.util.Map;

public class MatchControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private MatchManager matchManager = new MatchManager();
    private CsvFileManager csvFileManager = new CsvFileManager();

    public void run() {
//        try {
//            csvFileManager.readFile();
//        } catch (DataReadException e) {
//            e.getMessage();
//            printer.printLine("The new database has been initiated");
//            //pomyśleć co z drużynami dwuczłonowymi w drugim słowie są małe litery!!
//        }
        addTeams();
        printer.printLine("");
        printer.printLine("");
        detailsFirstRound();
        printer.printLine("");
        groupFirstRound();
        printer.printLine("");
        detailsRematch();
        printer.printLine("");
        groupRematches();
        printer.printLine("");
        joinAndSortByPointsAndGoalsScoring();
        printer.printLine("");
        sortByScoresFirstRound();
        printer.printLine("");
        sortByScoresRematches();
        printer.printLine("");
        sortByScoresAllMatches();
        printer.printLine("");
        sortByTeam();
        printer.printLine("");
        countByTeams();
        printer.printLine("");
        countByGoals();
//        try {
//            csvFileManager.writeFile(matchManager);
//            printer.printLine("Data write into file has been finished successfully");
//        } catch (DataWriteException e) {
//            e.getMessage();
//        }
//        printer.printLine("Match manager has finished its work");
    }

    private void addTeams() {
        int number = dataReader.numbersTeams();
        List<String> teams = matchManager.addTeams(number);
        printer.printInfoAboutAddedTeams(teams);
        printer.printTeams(teams);
    }

    private void detailsFirstRound() {
        List<String> teams = matchManager.getTeams();
        List<Match> matches = matchManager.createFirstRound(teams);
        List<Scoring> scoringFirstRound = matchManager.getScoringFirstRound();
        scoringFirstRound = matchManager.createScoring(matches, teams, scoringFirstRound);
        printer.printLine("Matches of the first round");
        matches.forEach(System.out::println);
        printer.printLine("");
        printer.printLine("Scoring of the first round");
        scoringFirstRound.forEach(System.out::println);
    }

    private void detailsRematch() {
        List<String> teams = matchManager.getTeams();
        List<Match> matches = matchManager.createRematch(teams);
        printer.printLine("Rematches");
        matches.forEach(System.out::println);
        List<Scoring> scoringRematches = matchManager.getScoringRematch();
        scoringRematches = matchManager.createScoring(matches, teams, scoringRematches);
        printer.printLine("");
        printer.printLine("Scoring of the rematches");
        scoringRematches.forEach(System.out::println);
    }

    private void groupFirstRound() {
        List<Scoring> scoring = matchManager.getScoringFirstRound();
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoring);
        printer.printLine("Grouping by the scoring of the first round");
        printer.printMap(scoringListMap);
        scoring = matchManager.getKey(scoringListMap);
        scoring = matchManager.sortByPointsAndGoals(scoring);
        printer.printLine("");
        printer.printLine("Sorted scoring Map for First Round");
        printer.printStandingsShortcuts();
        scoring = matchManager.increasePosition(scoring);
        scoring.forEach(System.out::println);
    }

    private void groupRematches() {
        List<Scoring> scoring = matchManager.getScoringRematch();
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoring);
        printer.printLine("Grouping by the scoring of the rematches");
        printer.printMap(scoringListMap);
        printer.printLine("");
        scoring = matchManager.getKey(scoringListMap);
        scoring = matchManager.sortByPointsAndGoals(scoring);
        printer.printLine("Sorted scoring Map for Rematches");
        printer.printStandingsShortcuts();
        scoring = matchManager.increasePosition(scoring);
        scoring.forEach(System.out::println);
    }

    private void joinAndSortByPointsAndGoalsScoring() {
        List<Scoring> scoringFirstRound = matchManager.getScoringFirstRound();
        List<Scoring> scoringRematches = matchManager.getScoringRematch();
        List<Scoring> allScoring = matchManager.joinFirstRoundAndRematches(scoringFirstRound, scoringRematches);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(allScoring);
        allScoring = matchManager.getKey(scoringListMap);
        printer.printLine("Joined scoring First Round and Rematches but not sorted");
        allScoring.forEach(System.out::println);
        printer.printLine("");
        allScoring = matchManager.sortByPointsAndGoals(allScoring);
        printer.printLine("Sorted scoring First Round and Rematches");
        printer.printStandingsShortcuts();
        allScoring = matchManager.increasePosition(allScoring);
        allScoring.forEach(System.out::println);
    }

    private void sortByScoresFirstRound() {
        List<Match> matches = matchManager.getMatchFirstRound();
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(matches);
        List<Match> ties = matchManager.sortByTies(matches);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(matches);
        matches = matchManager.joinWinTieLoss(winnersHome, ties, winnersAway);
        printer.printLine("Sort by matches from wins to loses of scoring FirstRound");
        matches.forEach(System.out::println);
    }

    private void sortByScoresRematches() {
        List<Match> matches = matchManager.getMatchRematch();
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(matches);
        List<Match> ties = matchManager.sortByTies(matches);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(matches);
        matches = matchManager.joinWinTieLoss(winnersHome, ties, winnersAway);
        printer.printLine("Sort by matches from wins to loses of scoring Rematches");
        matches.forEach(System.out::println);
    }

    private void sortByScoresAllMatches() {
        List<Match> firstRoundMatches = matchManager.getMatchFirstRound();
        List<Match> rematches = matchManager.getMatchRematch();
        List<Match> allMatches = matchManager.joinAllSortedMatchesByWinTiesLoss(firstRoundMatches, rematches);
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(allMatches);
        List<Match> ties = matchManager.sortByTies(allMatches);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(allMatches);
        allMatches = matchManager.joinWinTieLoss(winnersHome, ties, winnersAway);
        printer.printLine("Sort by matches from wins to loses of scoring all matches");
        allMatches.forEach(System.out::println);
    }

    private void sortByTeam() {
        List<String> teams = matchManager.getTeams();
        List<Match> firstRoundMatches = matchManager.getMatchFirstRound();
        List<Match> rematches = matchManager.getMatchRematch();
        List<Match> allMatches = matchManager.joinAllSortedMatchesByWinTiesLoss(firstRoundMatches, rematches);
        String team = matchManager.getTeam(teams);
        allMatches = matchManager.sortByTeam(allMatches, team);
        printer.printLine("All matches of the one team");
        allMatches.forEach(System.out::println);
    }

    private void countByTeams() {
        List<String> teams = matchManager.getTeams();
        long numberTeams = matchManager.countByTeams(teams);
        printer.printLine("The team numbers is: " + numberTeams);
    }

    private void countByGoals() {
        List<Match> matches = matchManager.getMatchFirstRound();
        long numberGoals = matchManager.countByGoals(matches);
        printer.printLine("The goal numbers is: " + numberGoals);
    }
}
