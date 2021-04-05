package javaStart.task39_Streams.exercise2.combined.io;

import javaStart.task39_Streams.exercise2.combined.model.Scoring;

import java.util.List;
import java.util.Map;

public class ConsolePrinter {
    public void printTeams(List<String> teams) {
        int counter = 0;
        for (String team : teams) {
            counter++;
            if (teams.size() == counter) {
                printNoLine(team + "");
            } else {
                printNoLine(team + ", ");
            }
        }
    }

    public void printInfoAboutAddedTeams(List<String> teams) {
        if (teams.isEmpty()) {
            printLineError("You didn't add any teams");
        } else {
            printLine("You added the following teams:");
        }
    }

    public void printMap(Map<Scoring, List<Scoring>> map) {
        for (Map.Entry<Scoring, List<Scoring>> entry : map.entrySet()) {
            printLine("" + entry.getKey());
        }
    }

    public void printStandingsShortcuts() {
        System.out.printf("%-5s %-20s %-3s %-3s %-3s %-3s\n", "Pos", "Team", "Pts", "GF", "GA", "GD");
    }

    public String printStandingsShortcutsTable() {
        return String.format("%-5s %-20s %-3s %-3s %-3s %-3s\n", "Pos", "Team", "Pts", "GF", "GA", "GD");
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
