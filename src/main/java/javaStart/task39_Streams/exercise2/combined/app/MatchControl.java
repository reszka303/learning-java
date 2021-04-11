package javaStart.task39_Streams.exercise2.combined.app;

import javaStart.task39_Streams.exercise2.combined.exception.DataReadException;
import javaStart.task39_Streams.exercise2.combined.exception.NoSuchOptionException;
import javaStart.task39_Streams.exercise2.combined.io.ConsolePrinter;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;
import javaStart.task39_Streams.exercise2.combined.io.file.CsvFileManager;
import javaStart.task39_Streams.exercise2.combined.model.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MatchControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private MatchManager matchManager = new MatchManager();
    private CsvFileManager csvFileManager = new CsvFileManager();
    private Division division = new League();

    public MatchControl() {
//        readFile();
    }

    void run() {
        controlLoop();
    }

    public void controlLoop() {
        Option option;
        do {
            printOption();
            option = getOption();
            switch (option) {
                case CHOOSE_ON_YOUR_OWN_TEAMS_TAKING_PART_IN_THE_COMPETITION:
                    chooseOnYourOwnTeamsTakingPartInCompetition();
                    break;
                case LA_LIGA:
                    laLiga();
                    break;
                case PREMIER_LEAGUE:
                    premierLeague();
                    break;
                case EXIT:
                    exit();
                    break;
            }
        } while (option != Option.EXIT);
    }

    private void readFile() {
        try {
            csvFileManager.readFile();
        } catch (DataReadException e) {
            e.getMessage();
            printer.printLine("The new database has been initiated");
        }
    }

    private void exit() {
//        try {
//            csvFileManager.writeFile(matchManager);
//            printer.printLine("Data write into file has been finished successfully");
//        } catch (DataWriteException e) {
//            e.getMessage();
//        }
        dataReader.close();
        printer.printLine("Match manager has finished its work");
    }

    private void chooseOnYourOwnTeamsTakingPartInCompetition() {
        userLeagueFirstRoundTable();
        userLeagueFirstRoundStats();
        userLeagueRematchesRoundTable();
        userLeagueRematchesStats();
        userLeagueAllMatches();
        userLeagueAllMatchesStats();
    }

    private void laLiga() {
        printer.printLine("LaLiga... work in progress");
    }

    private void premierLeague() {
        printer.printLine("Premier League... work in progress");
    }

    private void userLeagueFirstRoundTable() {
        int number = dataReader.numbersTeams();
        List<String> teams = matchManager.addTeams(number);
        printer.printLine("");
        printer.printInfoAboutAddedTeams(teams);
        printer.printTeams(teams);
        List<Match> matchesFirstRound = matchManager.createFirstRoundUserChoice(teams);
        printer.printLine("");
        printer.printLine("Scores of the first round");
        matchesFirstRound.forEach(System.out::println);
        List<Scoring> scoringFirstRound =  matchManager.createScoringUserChoiceFirstRound(matchesFirstRound, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByNameScoringUserChoiceFirstRound(scoringFirstRound);
        scoringFirstRound = matchManager.getKey(scoringListMap);
        scoringFirstRound = matchManager.sortByPointsAndGoals(scoringFirstRound);
        scoringFirstRound = matchManager.increasePosition(scoringFirstRound);
        printer.printLine("");
        printer.printLine("Table of the first round");
        scoringFirstRound.forEach(System.out::println);
        printer.printLine("");
    }

    private void userLeagueRematchesRoundTable() {
        List<String> teams = matchManager.getTeamsUserChoice();
//        printer.printInfoAboutAddedTeams(teams);
//        printer.printTeams(teams);
        List<Match> rematches = matchManager.createRematchUserChoice(teams);
        printer.printLine("");
        printer.printLine("Scores of the rematches");
        rematches.forEach(System.out::println);
        List<Scoring> scoringFirstRound =  matchManager.createScoringUserChoiceRematch(rematches, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByNameScoringUserChoiceRematch(scoringFirstRound);
        scoringFirstRound = matchManager.getKey(scoringListMap);
        scoringFirstRound = matchManager.sortByPointsAndGoals(scoringFirstRound);
        scoringFirstRound = matchManager.increasePosition(scoringFirstRound);
        printer.printLine("");
        printer.printLine("Table of the rematches");
        scoringFirstRound.forEach(System.out::println);
        printer.printLine("");
    }

    private void userLeagueFirstRoundStats() {
        List<String> teams = matchManager.getTeamsUserChoice();
        String team = matchManager.getTeam(teams);
        List<Match> matchesFirstRoundUserChoice = matchManager.getMatchUserChoiceFirstRound();
        List<Match> matchesFirstRoundOneTeam = matchManager.sortByTeam(matchesFirstRoundUserChoice, team);
        long countByGoals = matchManager.countByGoals(matchesFirstRoundUserChoice);
        int countByTeams = matchManager.countByTeams(teams);
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(matchesFirstRoundUserChoice);
        List<Match> ties = matchManager.sortByTies(matchesFirstRoundUserChoice);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(matchesFirstRoundUserChoice);
        List<Match> sortedMatchesFromWinnersToLosses = matchManager.joinWinTieLoss(winnersHome, ties, winnersAway);
        printer.printLine("");
        printer.printLine("Stats of the first round");
        printer.printLine("Team numbers is " + countByTeams);
        printer.printLine("");
        printer.printLine("Goals numbers is " + countByGoals);
        printer.printLine("");
        printer.printLine("all " + team + " matches");
        matchesFirstRoundOneTeam.forEach(System.out::println);
        printer.printLine("");
        printer.printLine("Sorted matches from wins to losses");
        sortedMatchesFromWinnersToLosses.forEach(System.out::println);
    }

    private void userLeagueRematchesStats() {
        List<String> teams = matchManager.getTeamsUserChoice();
        String team = matchManager.getTeam(teams);
        List<Match> rematchesUserChoice = matchManager.getMatchUserChoiceRematch();
        List<Match> rematchesOneTeam = matchManager.sortByTeam(rematchesUserChoice, team);
        long countByGoals = matchManager.countByGoals(rematchesUserChoice);
        int countByTeams = matchManager.countByTeams(teams);
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(rematchesUserChoice);
        List<Match> ties = matchManager.sortByTies(rematchesUserChoice);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(rematchesUserChoice);
        List<Match> sortedMatchesFromWinnersToLosses = matchManager.joinWinTieLoss(winnersHome, ties, winnersAway);
        printer.printLine("");
        printer.printLine("Stats of the rematches");
        printer.printLine("Team numbers is " + countByTeams);
        printer.printLine("");
        printer.printLine("Goals numbers is " + countByGoals);
        printer.printLine("");
        printer.printLine("all " + team + " matches");
        rematchesOneTeam.forEach(System.out::println);
        printer.printLine("");
        printer.printLine("Sorted matches from wins to losses");
        sortedMatchesFromWinnersToLosses.forEach(System.out::println);
    }

    private void userLeagueAllMatches() {
        printer.printLine("");
        printer.printLine("All Matches");
        List<String> teams = matchManager.getTeamsUserChoice();
        List<Match> allMatches = matchManager.joinFirstRoundAndRematches();
        allMatches.forEach(System.out::println);
        List<Scoring> scoringAllMatches = matchManager.createScoringUserChoiceAllMatches(allMatches, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByNameScoringUserAllMatches(scoringAllMatches);
        scoringAllMatches = matchManager.getKey(scoringListMap);
        scoringAllMatches = matchManager.sortByPointsAndGoals(scoringAllMatches);
        scoringAllMatches = matchManager.increasePosition(scoringAllMatches);
        printer.printLine("");
        printer.printLine("Table all matches");
        scoringAllMatches.forEach(System.out::println);
    }

    private void userLeagueAllMatchesStats() {
        List<String> teams = matchManager.getTeamsUserChoice();
        String team = matchManager.getTeam(teams);
        List<Match> allMatchesUserChoice = matchManager.getMatchUserChoiceAllMatches();
        List<Match> allMatchesOneTeam = matchManager.sortByTeam(allMatchesUserChoice, team);
        long countByGoals = matchManager.countByGoals(allMatchesUserChoice);
        int countByTeams = matchManager.countByTeams(teams);
        List<Match> winnersHome = matchManager.sortByWinnersHomeTeam(allMatchesUserChoice);
        List<Match> ties = matchManager.sortByTies(allMatchesUserChoice);
        List<Match> winnersAway = matchManager.sortByWinnersAwayTeam(allMatchesUserChoice);
        List<Match> sortedMatchesFromWinnersToLosses = matchManager.joinWinTieLoss(winnersHome, ties, winnersAway);
        printer.printLine("");
        printer.printLine("Stats of the rematches");
        printer.printLine("Team numbers is " + countByTeams);
        printer.printLine("");
        printer.printLine("Goals numbers is " + countByGoals);
        printer.printLine("");
        printer.printLine("all " + team + " matches");
        allMatchesOneTeam.forEach(System.out::println);
        printer.printLine("");
        printer.printLine("Sorted matches from wins to losses");
        sortedMatchesFromWinnersToLosses.forEach(System.out::println);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                e.getMessage();
            }
        }
        return option;
    }

    private void printOption() {
        for (Option option : Option.values()) {
            printer.printLine("" + option);
        }
    }

    private enum Option{
        EXIT(0, "Exit"),
        CHOOSE_ON_YOUR_OWN_TEAMS_TAKING_PART_IN_THE_COMPETITION(1,
                "Choose on your own teams taking part in the competition."),
        LA_LIGA(2, "La Liga"),
        PREMIER_LEAGUE(3, "Premier League");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        private static Option createFromInt(int option) {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("There is no such option " + option + " try again");
            }
        }
    }
}
