package javaStart.task39_Streams.exercise2.combined.app;

import javaStart.task39_Streams.exercise2.combined.io.ConsolePrinter;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;
import javaStart.task39_Streams.exercise2.combined.model.Match;
import javaStart.task39_Streams.exercise2.combined.model.MatchManager;
import javaStart.task39_Streams.exercise2.combined.model.Result;

import java.util.List;

public class MatchControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private MatchManager matchManager = new MatchManager();

    void run() {
        addTeams();
        System.out.println();
        printResultsGivenTeams();
    }

    private void addTeams() {
        int number = dataReader.numbersTeams();
        List<String> teams = matchManager.addTeams(number);
        printer.printInfoAboutAddedTeams(teams);
        printer.printTeams(teams);
    }

    private void printResultsGivenTeams() {
        List<String> teams = matchManager.getTeams();
        List<Match> matches = matchManager.createScores(teams);
        List<Result> results = matchManager.getScores(matches, teams);
        matches.forEach(System.out::println);
        results.forEach(System.out::println);
    }

    private enum Option {
        EXIT(0, "Exit"),
        ADD_TEAM(1,"Add team"),
        PRINT_RESULTS_GIVEN_TEAMS(2, "Print results given teams");

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        int value;
        String description;
    }
}
