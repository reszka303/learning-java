package javaStart.task39_Streams.exercise2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchResultManager {
    Stream<MatchResult> matches() {
        return Stream.of(
                new MatchResult("Brazil", "France", 0, 3),
                new MatchResult("England", "Germany", 1, 2),
                new MatchResult("Brazil", "Argentina", 2, 2),
                new MatchResult("Brazil", "Germany", 3, 3),
                new MatchResult("Italy", "Poland", 2, 1),
                new MatchResult("Poland", "Portugal", 1,  0),
                new MatchResult("Poland", "Ireland", 3,  0),
                new MatchResult("England", "France", 4, 1)
        );
    }

    void printAllResultsSorted(Stream<MatchResult> matches) {
        matches.sorted(Comparator.comparing(MatchResult::getGoalDifference).reversed()).forEach(System.out::println);
    }

    //Steps
    //Poland-France (1:2), Poland-England (1:0)
    //write to list with the higher
    List<MatchResult> createListWinsHomeTeam(Stream<MatchResult> matches) {
        return matches.filter(MatchResult::sortWinsHomeTeam)
                .sorted((m1, m2) -> Integer.compare(m1.getGoalsHomeTeam(), m2.getGoalsHomeTeam()))
                .collect(Collectors.toList());
    }

    List<MatchResult> createListWinsAwayTeam(Stream<MatchResult> matches) {
        return matches.filter(MatchResult::sortWinsAwayTeam)
                .collect(Collectors.toList());
    }

    List<MatchResult> sortWinsHomeTeam(List<MatchResult> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(MatchResult::getGoalsHomeTeam).reversed())
                .collect(Collectors.toList());
    }

    List<MatchResult> sortWinsAwayTeam(List<MatchResult> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(MatchResult::getGoalsAwayTeam).reversed())
                .collect(Collectors.toList());
    }

    List<MatchResult> sortTieResults(Stream<MatchResult> matches) {
        return matches.filter(MatchResult::sortTieResults)
                .collect(Collectors.toList());
    }

    List<MatchResult> getResultsWithTeam(Stream<MatchResult> matches, String team) {
        return matches.filter(match -> match.containsTeam(team))
                .collect(Collectors.toList());
    }

    //Kroki co chcemy zrobić
    //Poland-France (1:2), Poland-England (1:0)
    //Poland-France, Poland-England
    //Poland,France,Poland,England
    //Poland,France, England
    long countUniqueTeam(Stream<MatchResult> matches) {
        return matches.map(MatchResult::getTeamsList)
                .flatMap(List<String>::stream)
                .distinct()
                .count();
    }

    //Kroki co chcemy zrobić
    //Poland-France (1:2), Poland-England (1:0)
    //(1:2), (1:0) - przekształcenie strumienia w strumień IntStream za pomocą metody mapToInt
    //1+2+1+0 sumowanie wszystkich liczb
    long countGoalsAllMatches(Stream<MatchResult> matches) {
        return matches.mapToInt(MatchResult::getGoalsSum)
                .sum();

    }

    void printLine(String text) {
        System.out.println(text);
    }
}
