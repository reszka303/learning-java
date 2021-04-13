package javaStart.task39_Streams.exercise2.combined.app.test;

import javaStart.task39_Streams.exercise2.combined.model.Scoring;

import java.util.*;
import java.util.stream.Collectors;

public class T12 {
    public static void main(String[] args) {

    }

    public Map<Scoring, List<Scoring>> groupByNameScoringUserAllMatches(List<Scoring> scoring) {
        return  scoring.stream()
                .collect(Collectors.groupingBy(Scoring::getName))
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> {
                    int place = 1;
                    int sumPoints = entry.getValue().stream().mapToInt(Scoring::getPoints).sum();
                    int sumGoalsFor = entry.getValue().stream().mapToInt(Scoring::getGoalsFor).sum();
                    int sumGoalsAgainst = entry.getValue().stream().mapToInt(Scoring::getGoalsAgainst).sum();
                    int sumGoalsDifference = entry.getValue().stream().mapToInt(Scoring::getGoalsDifference).sum();
                    return new Scoring(place, entry.getKey(), sumPoints, sumGoalsFor, sumGoalsAgainst, sumGoalsDifference);
                }, Map.Entry::getValue));
    }

    private static void createList() {
        List<Scoring> scoring = new ArrayList<>();
        scoring.add(new Scoring(1, "Polska", 3,3,1,2));
        scoring.add(new Scoring(1, "Polska", 1,   1,   1,   0));
        scoring.add(new Scoring(1, "Polska", 0,   0,   3,   -3));
        scoring.add(new Scoring(1, "Włochy", 0,   1,   3,   -2));
        scoring.add(new Scoring(1, "Włochy", 3,   4,   1,   3));
        scoring.add(new Scoring(1, "Włochy", 0,   2,   3,   -1 ));
        scoring.add(new Scoring(1, "Francja", 1,   1,   1,   0));
        scoring.add(new Scoring(1, "Francja", 0,   1,   4,   -3 ));
        scoring.add(new Scoring(1, "Francja", 3,   4,   1,   3));
        scoring.add(new Scoring(1, "Grecja", 3,   3,   0,   3 ));
        scoring.add(new Scoring(1, "Grecja",  3,   3,   2,   1));
        scoring.add(new Scoring(1, "Grecja", 0,   1,   4,   -3));


    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
