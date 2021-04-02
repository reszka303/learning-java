package javaStart.task39_Streams.exercise2.combined.model;

public class Table {
    private int place;
    private String name;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;

    public Table(int place, String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
        this.place = place;
        this.name = name;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
    }

    public String toString() {
        return String.format("%-5s %-10s %-3s %-3s %-3s %-3s",place + ".", name, points, goalsFor, goalsAgainst, goalsDifference);
    }
}
