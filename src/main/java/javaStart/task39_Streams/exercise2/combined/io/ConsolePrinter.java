package javaStart.task39_Streams.exercise2.combined.io;

import javaStart.task39_Streams.exercise2.combined.model.Result;

import java.util.List;
import java.util.Map;

public class ConsolePrinter {
    public void printTeams(List<String> teams) {
        int counter = 0;
        for (String team : teams) {
            counter++;
            if (teams.size() == counter) {
                printNoLine(firstUpper(team) + "");
            } else {
                printNoLine(firstUpper(team) + ", ");
            }
        }
    }

    public String firstUpper(String team) {
        return team.substring(0, 1).toUpperCase() + team.substring(1).toLowerCase();
    }

    public void printInfoAboutAddedTeams(List<String> teams) {
        if (teams.isEmpty()) {
            printLineError("You didn't add teams");
        } else {
            printLine("You added the following teams:");
        }
    }

    public void printMap(Map<Result, List<Result>> map) {
        for (Map.Entry<Result, List<Result>> entry : map.entrySet()) {
            printLine("" + entry.getKey());
        }
    }

    public void printStandingsShortcuts() {
        System.out.printf("%-10s %-3s %-3s %-3s %-3s\n", "Team", "Pts", "GF", "GA", "GD");
    }

    public String printStandingsShortcutsTable() {
        return String.format("%-3s %-10s %-3s %-3s %-3s %-3s\n", "Place", "Team", "Pts", "GF", "GA", "GD");
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
