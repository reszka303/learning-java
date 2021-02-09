package javaStart.task39_Streams.exercise2.basic;

import java.util.List;

public class MatchResultControl {
    void run() {
        MatchResultManager matchResultManager = new MatchResultManager();

        matchResultManager.printLine("The matches in the original order: ");
        matchResultManager.matches().forEach(System.out::println);

        System.out.println(">>>");

        matchResultManager.printLine("The matches by sorted: ");
        matchResultManager.printAllResultsSorted(matchResultManager.matches());

        System.out.println(">>>");

        matchResultManager.printLine("All matches of Poland");
        matchResultManager.getResultsWithTeam(matchResultManager.matches(), "Poland").forEach(System.out::println);

        System.out.println(">>>");

        matchResultManager.printLine("The numbers of teams participated in the challenged: " +
                matchResultManager.countUniqueTeam(matchResultManager.matches()));

        System.out.println(">>>");

        matchResultManager.printLine("Total number of goals is: " + matchResultManager.countGoalsAllMatches(matchResultManager.matches()));

        System.out.println(">>>");

        matchResultManager.printLine("Ties:");
        matchResultManager.createTiesResults(matchResultManager.matches()).forEach(System.out::println);

        System.out.println(">>>");

        List<MatchResult> createListHomeTeamWins = matchResultManager.createListWinsHomeTeam(matchResultManager.matches());
        List<MatchResult> homeTeamWins = matchResultManager.sortWinsHomeTeam(createListHomeTeamWins);


        System.out.println("Sorted by the highest home team goals");
        homeTeamWins.forEach(System.out::println);

        System.out.println(">>>");

        List<MatchResult> createListAwayTeamWins = matchResultManager.createListWinsAwayTeam(matchResultManager.matches());
        List<MatchResult> awayTeamWins = matchResultManager.sortWinsAwayTeam(createListAwayTeamWins);

        System.out.println("Sorted by the highest away team goals");
        awayTeamWins.forEach(System.out::println);

        System.out.println(">>>");

        List<MatchResult> createListTies = matchResultManager.createTiesResults(matchResultManager.matches());
        List<MatchResult> ties = matchResultManager.sortTiesResults(createListTies);

        System.out.println("Sorted by the ties");
        ties.forEach(System.out::println);

        System.out.println(">>>");

        List<MatchResult> allMatches = matchResultManager.combineList(homeTeamWins, ties, awayTeamWins);
        System.out.println("All sorted matches in one list");
        allMatches.forEach(System.out::println);
    }
}
