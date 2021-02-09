package javaStart.task39_Streams.exercise2.extended;

public class Result {
    private Match match;
    private int played;
    private int won;
    private int drawn;
    private int loss;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;

    public Result(Match match, int played, int won, int drawn, int loss, int goalsFor, int goalsAgainst, int goalsDifference) {
        this.match = match;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.loss = loss;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
    }

    public Match getMatch() {
        return match;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLoss() {
        return loss;
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
        return  match + " " + played + " " + won + " " + drawn + " " + loss + " " + goalsFor + " " + goalsAgainst
                + " " + goalsDifference;
    }
}
