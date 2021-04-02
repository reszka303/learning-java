package javaStart.task39_Streams.exercise2.combined.model;

import java.util.List;

public class Result {
    private int position;
    private String name;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;

    public Result(int position, String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
        this.position = position;
        this.name = name;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
    }

    public int getPosition() {
        return position;
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

    public void setPosition(int position) {
        this.position = position;
    }

    public List<String> getTeams() {
        return List.of(name);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-3s %-3s %-3s %-3s", position + ".", name, points, goalsFor,
                goalsAgainst, goalsDifference);
    }
}
