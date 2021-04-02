package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        List<String> teams = create();
        teams = upperAndLowerCase(teams);
        String collect = join(teams);
        printLine(collect);
    }

    private static List<String> upperAndLowerCase(List<String> teams) {
        List<String> teamsUpperAndLowerCase = new ArrayList<>();
        for (String team : teams) {
            teamsUpperAndLowerCase.add(getString(team));
        }
        return teamsUpperAndLowerCase;
    }

    private static String join(List<String> teams) {
        return String.join(", ", teams);
    }

    private static List<String> create() {
        List<String> teams = new ArrayList<>();
        teams.add("Poland");
        teams.add("italy");
        teams.add("gERMANY");
        return teams;
    }

    private static String getString(String team) {
        return team.substring(0, 1).toUpperCase() + team.substring(1).toLowerCase();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
