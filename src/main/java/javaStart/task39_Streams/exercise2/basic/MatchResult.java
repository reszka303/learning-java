package javaStart.task39_Streams.exercise2.basic;

import java.util.ArrayList;
import java.util.List;

public class MatchResult {
    private String homeTeam;
    private String awayTeam;
    private int goalsHomeTeam;
    private int goalsAwayTeam;

    public MatchResult(String homeTeam, String awayTeam, int goalsHomeTeam, int goalsAwayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    int getGoalDifference() {
        return goalsHomeTeam - goalsAwayTeam;
    }

    boolean containsTeam(String team) {
        return homeTeam.equals(team) || awayTeam.equals(team);
    }

    String[] getTeamsArray() {
        return new String[] {homeTeam, awayTeam};
    }

    List<String> getTeamsList() {
        return List.of(homeTeam, awayTeam);
    }

    int getGoalsSum() {
        return goalsHomeTeam + goalsAwayTeam;
    }

    boolean sortWinsHomeTeam() {
        return goalsHomeTeam > goalsAwayTeam;
    }

    boolean sortWinsAwayTeam() {
        return goalsHomeTeam < goalsAwayTeam;
    }

    boolean sortTieResults() {
        return goalsHomeTeam == goalsAwayTeam;
    }

    @Override
    public String toString() {
        return homeTeam + "-" + awayTeam + " (" + goalsHomeTeam + ":" + goalsAwayTeam + ")";
    }
}