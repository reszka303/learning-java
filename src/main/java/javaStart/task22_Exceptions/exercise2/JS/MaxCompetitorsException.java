package javaStart.task22_Exceptions.exercise2.JS;

public class MaxCompetitorsException extends RuntimeException {
    private final int maxCompetitors;

    public MaxCompetitorsException(int maxCompetitors) {
        this.maxCompetitors = maxCompetitors;
    }

    public int getMaxCompetitors() {
        return maxCompetitors;
    }
}
