package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T9CreateRematches {
    private static List<Match> matches = new ArrayList<>();
    private static List<String> teams = new ArrayList<>();
    public static void main(String[] args) {
        teams = teams();
        matches = createScoresFirstRound(teams);
//        printLine("First round");
//        matches.forEach(System.out::println);
        printLine("");
        printLine("Second round");
        matches = createScoresSecondRound(teams());
        matches.forEach(System.out::println);
    }

    private static List<Match> createScoresSecondRound(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(j), teams.get(i), random.nextInt(upperbound), random.nextInt(upperbound));
                matches.add(match);
            }
        }
        return matches;
    }

    private static List<Match> createScoresFirstRound(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j), random.nextInt(upperbound), random.nextInt(upperbound));
                matches.add(match);
            }
        }
        return matches;
    }

    private static List<String> teams() {
        List<String> teams = new ArrayList<>();
        teams.add("1");
        teams.add("2");
        teams.add("3");
        teams.add("4");
//        teams.add("Sweden");
        return teams;
    }

    private static class Match {
        private String homeTeam;
        private String awayTeam;
        private int homeTeamGoal;
        private int awayTeamGoal;

        public Match(String homeTeam, String awayTeam, int homeTeamGoal, int awayTeamGoal) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.homeTeamGoal = homeTeamGoal;
            this.awayTeamGoal = awayTeamGoal;
        }

        public String getHomeTeam() {
            return homeTeam;
        }

        public String getAwayTeam() {
            return awayTeam;
        }

        public int getHomeTeamGoal() {
            return homeTeamGoal;
        }

        public int getAwayTeamGoal() {
            return awayTeamGoal;
        }

        public boolean getWinnersHomeTeam() {
            return homeTeamGoal > awayTeamGoal;
        }

        public boolean getTies() {
            return homeTeamGoal == awayTeamGoal;
        }

        public boolean getWinnersAwayTeam() {
            return homeTeamGoal < awayTeamGoal;
        }

        public int getGoalsHomeAndAwayTeams() {
            return homeTeamGoal + awayTeamGoal;
        }

        @Override
        public String toString() {
            return homeTeam + " - " + awayTeam + " (" + homeTeamGoal + ":" + awayTeamGoal + ")";
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
