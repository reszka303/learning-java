package javaStart.task39_Streams.exercise2.combined.model;

public class Match {
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
