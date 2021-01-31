package javaStart.task39_Streams.exercise2;

import java.util.List;

public class MatchResultRunner {
    public static void main(String[] args) {
        MatchResultManager matchResultManager = new MatchResultManager();

        matchResultManager.printLine("The matches in the original order: ");
        matchResultManager.matches().forEach(System.out::println);

        System.out.println(">>>");

        matchResultManager.printLine("The matches after sorting: ");
        matchResultManager.printAllResultsSorted(matchResultManager.matches());

        System.out.println(">>>");

        matchResultManager.printLine("All matches of Poland");
        matchResultManager.getResultsWithTeam(matchResultManager.matches(), "Poland").forEach(System.out::println);

        System.out.println(">>>");

        matchResultManager.printLine("The numbers of teams participated in the challenge is: " +
                matchResultManager.countUniqueTeam(matchResultManager.matches()));

        System.out.println(">>>");

        matchResultManager.printLine("Total number of goals is: " + matchResultManager.countGoalsAllMatches(matchResultManager.matches()));

        System.out.println(">>>");

        matchResultManager.printLine("Wins of home team");
        matchResultManager.createListWinsHomeTeam(matchResultManager.matches()).forEach(System.out::println);

        List<MatchResult> matchesWins = matchResultManager.createListWinsHomeTeam(matchResultManager.matches());
        List<MatchResult> homeWins = matchResultManager.sortWinsHomeTeam(matchesWins);

        System.out.println(">>>");

        System.out.println("Sorting by the most numbers of goals of home team");
        homeWins.forEach(System.out::println);

        System.out.println(">>>");

        matchResultManager.printLine("Wins of away team");
        matchResultManager.createListWinsAwayTeam(matchResultManager.matches()).forEach(System.out::println);

        System.out.println(">>>");

        matchResultManager.printLine("Ties:");
        matchResultManager.sortTieResults(matchResultManager.matches()).forEach(System.out::println);

        System.out.println(">>>");



    }
}
