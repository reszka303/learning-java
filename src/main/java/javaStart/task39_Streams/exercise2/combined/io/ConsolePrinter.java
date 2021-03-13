package javaStart.task39_Streams.exercise2.combined.io;

import javaStart.task39_Streams.exercise2.combined.model.Match;

import java.util.List;

public class ConsolePrinter {
    public void printTeams(List<String> teams) {
        int counter = 0;
        for (String team : teams) {
            counter++;
            if (teams.size() == counter) {
                printNoLine(getString(team) + "");
            } else {
                printNoLine(getString(team) + ", ");
            }
        }
    }

    private String getString(String team) {
        return team.substring(0, 1).toUpperCase() + team.substring(1).toLowerCase();
    }

    public void printInfoAboutAddedTeams(List<String> teams) {
        if (teams.isEmpty()) {
            printLineError("You didn't add teams");
        } else {
            printLine("You added the following teams:");
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printNoLine(String text) {
        System.out.print(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
