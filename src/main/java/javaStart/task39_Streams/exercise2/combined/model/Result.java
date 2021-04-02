package javaStart.task39_Streams.exercise2.combined.model;

import java.util.List;

public class Result {
    private int place;
    private String name;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;

//    public Result(String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
//        this.name = name;
//        this.points = points;
//        this.goalsFor = goalsFor;
//        this.goalsAgainst = goalsAgainst;
//        this.goalsDifference = goalsDifference;
//    }

    public Result(int place, String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
        this.place = place;
        this.name = name;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
    }

    public int getPlace() {
        return place;
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

    public void setPlace(int place) {
        this.place = place;
    }

    public List<String> getTeams() {
        return List.of(name);
    }


//    @Override
//    public String toString() {
//        return String.format("%-10s %-3s %-3s %-3s %-3s", name, points, goalsFor, goalsAgainst, goalsDifference);
//    }

    public String toString() {
        return String.format("%-5s %-10s %-3s %-3s %-3s %-3s",place + ".", name, points, goalsFor, goalsAgainst, goalsDifference);
    }
}
