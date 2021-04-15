package javaStart.task39_Streams.exercise2.combined.app;

import javaStart.task39_Streams.exercise2.combined.exception.DataReadException;
import javaStart.task39_Streams.exercise2.combined.exception.DataWriteException;
import javaStart.task39_Streams.exercise2.combined.exception.NoSuchOptionException;
import javaStart.task39_Streams.exercise2.combined.io.ConsolePrinter;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;
import javaStart.task39_Streams.exercise2.combined.io.file.CsvFileManager;
import javaStart.task39_Streams.exercise2.combined.io.file.FileManager;
import javaStart.task39_Streams.exercise2.combined.model.*;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class MatchControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private MatchManager matchManager = new MatchManager();
    private FileManager fileManager = new CsvFileManager();
    private League league = new EuropeanLeague();
//    private MatchManager matchManager;

    public MatchControl() {
//        matchManager = new MatchManager();
    }

    void run() {
        controlLoop();
    }

    public void controlLoop() {
        readFile();
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
            fileManager.readFile();
        } catch (DataReadException e) {
            e.getMessage();
            printer.printLine("The new database has been initiated");
        }
    }

    private void exit() {
        try {
            fileManager.writeFile(matchManager);
            printer.printLine("Data write into file has been finished successfully");
        } catch (DataWriteException e) {
            e.getMessage();
        }
        dataReader.close();
        printer.printLine("Match manager has finished its work");
    }

    private void laLiga() {
        laLigaFirstRound();
        laLigaStatsFirstRound();
        laLigaRematches();
        laLigaStatsRematches();
        allMatchesLaLiga();
        laLigaStatsAllMatches();
    }

    private void premierLeague() {
        premierLeagueFirstRound();
        premierLeagueStatsFirstRound();
        premierLeagueRematches();
        premierLeagueStatsRematches();
        allMatchesPremierLeague();
        premierLeagueStatsAllMatches();
    }

    private void chooseOnYourOwnTeamsTakingPartInCompetition() {
        userLeagueFirstRoundTable();
        userLeagueFirstRoundStats();
        userLeagueRematchesRoundTable();
        userLeagueRematchesStats();
        userLeagueAllMatches();
        userLeagueAllMatchesStats();
    }

    private void laLigaFirstRound() {
        List<String> teams = league.laLiga();
        printer.printLine("");
        printer.printLine("Teams taking part in the competition");
        printer.printTeams(teams);
        printer.printLine("");
        List<Match> matchesFirstRound = matchManager.createFirstRoundLaLiga(teams);
        printer.printLine("__________________________________________________");
        printer.printLine("Matches of the first round");
        matchesFirstRound.forEach(System.out::println);
        List<Scoring> scoringFirstRound =  matchManager.createScoringFirstRoundLaLiga(matchesFirstRound, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringFirstRound);
        scoringFirstRound = matchManager.getKey(scoringListMap);
        scoringFirstRound = matchManager.sortByPointsAndGoals(scoringFirstRound);
        scoringFirstRound = matchManager.increasePosition(scoringFirstRound);
        printer.printLine("");
        printer.printLine("Table of the first round");
        scoringFirstRound.forEach(System.out::println);
        printer.printLine("");
    }

    private void premierLeagueFirstRound() {
        List<String> teams = league.premierLeague();
        printer.printLine("");
        printer.printLine("Teams taking part in the competition");
        printer.printTeams(teams);
        printer.printLine("");
        List<Match> matchesFirstRound = matchManager.createFirstRoundPremierLeague(teams);
        printer.printLine("__________________________________________________");
        printer.printLine("Matches of the first round");
        matchesFirstRound.forEach(System.out::println);
        List<Scoring> scoringFirstRound =  matchManager.createScoringFirstRoundPremierLeague(matchesFirstRound, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringFirstRound);
        scoringFirstRound = matchManager.getKey(scoringListMap);
        scoringFirstRound = matchManager.sortByPointsAndGoals(scoringFirstRound);
        scoringFirstRound = matchManager.increasePosition(scoringFirstRound);
        printer.printLine("");
        printer.printLine("Table of the first round");
        scoringFirstRound.forEach(System.out::println);
        printer.printLine("");
    }

    private void laLigaStatsFirstRound() {
        List<Match> matchesFirstRound = matchManager.getMatchFirstRoundLaLiga();
        long countByGoals = matchManager.countByGoals(matchesFirstRound);
        printer.printLine("The number of goals in the first round of LaLiga is as follows: " + countByGoals);
    }

    private void premierLeagueStatsFirstRound() {
        List<Match> matchesFirstRound = matchManager.getMatchFirstRoundPremierLeague();
        long countByGoals = matchManager.countByGoals(matchesFirstRound);
        printer.printLine("The number of goals in the first round of Premier League is as follows: " + countByGoals);
    }

    private void laLigaRematches() {
        printer.printLine("__________________________________________________");
        printer.printLine("Rematches");
        List<String> teams = league.laLiga();
        printer.printLine("");
        List<Match> rematchesLaLiga = matchManager.createRematchPremierLeague(teams);
        printer.printLine("Results of rematches");
        rematchesLaLiga.forEach(System.out::println);
        List<Scoring> scoringFirstRound =  matchManager.createScoringRematchLaLiga(rematchesLaLiga, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringFirstRound);
        scoringFirstRound = matchManager.getKey(scoringListMap);
        scoringFirstRound = matchManager.sortByPointsAndGoals(scoringFirstRound);
        scoringFirstRound = matchManager.increasePosition(scoringFirstRound);
        printer.printLine("");
        printer.printLine("Table of the rematches");
        scoringFirstRound.forEach(System.out::println);
        printer.printLine("");
    }

    private void premierLeagueRematches() {
        printer.printLine("__________________________________________________");
        printer.printLine("Rematches");
        List<String> teams = league.premierLeague();
        printer.printLine("");
        List<Match> rematchesPremierLeague = matchManager.createRematchPremierLeague(teams);
        printer.printLine("Results of rematches");
        rematchesPremierLeague.forEach(System.out::println);
        List<Scoring> scoringFirstRound =  matchManager.createScoringRematchPremierLeague(rematchesPremierLeague, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringFirstRound);
        scoringFirstRound = matchManager.getKey(scoringListMap);
        scoringFirstRound = matchManager.sortByPointsAndGoals(scoringFirstRound);
        scoringFirstRound = matchManager.increasePosition(scoringFirstRound);
        printer.printLine("");
        printer.printLine("Table of the rematches");
        scoringFirstRound.forEach(System.out::println);
        printer.printLine("");
    }

    private void laLigaStatsRematches() {
        List<Match> rematches = matchManager.getMatchRematchesLaLiga();
        long countByGoals = matchManager.countByGoals(rematches);
        printer.printLine("The number of goals in the rematches of LaLiga is as follows: " + countByGoals);
    }

    private void premierLeagueStatsRematches() {
        List<Match> rematches = matchManager.getMatchRematchesPremierLeague();
        long countByGoals = matchManager.countByGoals(rematches);
        printer.printLine("The number of goals in the rematches of Premier League is as follows: " + countByGoals);
    }

    private void allMatchesLaLiga() {
        printer.printLine("__________________________________________________");
        printer.printLine("All Matches");
        List<String> teams = league.laLiga();
        List<Match> allMatches = matchManager.joinFirstRoundAndRematchesLaLiga();
//        allMatches.forEach(System.out::println);
        List<Scoring> scoringAllMatches = matchManager.createScoringAllMatchesLaLiga(allMatches, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringAllMatches);
        scoringAllMatches = matchManager.getKey(scoringListMap);
        scoringAllMatches = matchManager.sortByPointsAndGoals(scoringAllMatches);
        scoringAllMatches = matchManager.increasePosition(scoringAllMatches);
        printer.printLine("");
        printer.printLine("Table all matches");
        scoringAllMatches.forEach(System.out::println);
    }

    private void allMatchesPremierLeague() {
        printer.printLine("__________________________________________________");
        printer.printLine("All Matches");
        List<String> teams = league.premierLeague();
        List<Match> allMatches = matchManager.joinFirstRoundAndRematchesPremierLeague();
//        allMatches.forEach(System.out::println);
        List<Scoring> scoringAllMatches = matchManager.createScoringAllMatchesPremierLeague(allMatches, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringAllMatches);
        scoringAllMatches = matchManager.getKey(scoringListMap);
        scoringAllMatches = matchManager.sortByPointsAndGoals(scoringAllMatches);
        scoringAllMatches = matchManager.increasePosition(scoringAllMatches);
        printer.printLine("");
        printer.printLine("Table all matches");
        scoringAllMatches.forEach(System.out::println);
    }

    private void laLigaStatsAllMatches() {
        List<Match> allMatches = matchManager.getMatchAllMatchesLaLiga();
        long countByGoals = matchManager.countByGoals(allMatches);
        printer.printLine("The number of goals in the all matches of LaLiga is as follows: " + countByGoals);
    }

    private void premierLeagueStatsAllMatches() {
        List<Match> allMatches = matchManager.getMatchAllMatchesPremierLeague();
        long countByGoals = matchManager.countByGoals(allMatches);
        printer.printLine("The number of goals in the all matches of Premier League is as follows: " + countByGoals);
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
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringFirstRound);
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
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringFirstRound);
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
        String team = matchManager.getTeamFirstRoundUserChoice(teams);
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
        String team = matchManager.getTeamRematchesUserChoice(teams);
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
        List<Match> allMatches = matchManager.joinFirstRoundAndRematchesUserChoice();
        allMatches.forEach(System.out::println);
        List<Scoring> scoringAllMatches = matchManager.createScoringUserChoiceAllMatches(allMatches, teams);
        Map<Scoring, List<Scoring>> scoringListMap = matchManager.groupByName(scoringAllMatches);
        scoringAllMatches = matchManager.getKey(scoringListMap);
        scoringAllMatches = matchManager.sortByPointsAndGoals(scoringAllMatches);
        scoringAllMatches = matchManager.increasePosition(scoringAllMatches);
        printer.printLine("");
        printer.printLine("Table all matches");
        scoringAllMatches.forEach(System.out::println);
    }

    private void userLeagueAllMatchesStats() {
        List<String> teams = matchManager.getTeamsUserChoice();
        String team = matchManager.getTeamAllMatchesUserChoice(teams);
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
            } catch (InputMismatchException e) {
                printer.printLineError("Enter a digit, try again");
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
