package javaStart.task39_Streams.exercise2.extended;

public class PointsAndGoals {
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;

    public PointsAndGoals(int points, int goalsFor, int goalsAgainst, int goalsDifference) {
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
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

    int sumPoint() {
        int sum = 0;
        return sum += points;
    }

    int sumGoalsFor() {
        int sum = 0;
        return sum += goalsFor;
    }

    int sumGoalAgainst() {
        int sum = 0;
        return sum+= goalsAgainst;
    }

    int sumGoalsDifference() {
        int sum = 0;
        return sum+= goalsDifference;
    }

    @Override
    public String toString() {
        return "Points: " +  points + " - " + " GoalsFor: " + goalsFor + " - " + " GoalsAgainst: "
                + goalsAgainst + " - " + " GoalsDifference: " + goalsDifference;
    }
}
