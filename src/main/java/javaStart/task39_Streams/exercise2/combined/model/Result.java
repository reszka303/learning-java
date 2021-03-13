package javaStart.task39_Streams.exercise2.combined.model;

public class Result {
    private String name;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;

    public Result(String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
        this.name = name;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-3s %-3s %-3s %-3s", name, points, goalsFor, goalsAgainst, goalsDifference);
    }
}
