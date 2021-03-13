package javaStart.task39_Streams.exercise2.extended;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MatchManager{
    public static void main(String[] args) {
        List<String> teams = teams();
        List<Match> matches = scores(teams);
        System.out.println("Results");
        matches.forEach(System.out::println);
//        System.out.println();

        List<Result> resultsPoland = getResults(matches, "Poland");
        resultsPoland.forEach(System.out::println);
        System.out.println();

        List<Result> resultsItaly = getResults(matches, "Italy");
//        resultsItaly.forEach(System.out::println);
//        System.out.println();

        List<Result> resultsGermany = getResults(matches, "Germany");
//        resultsGermany.forEach(System.out::println);
//        System.out.println();

        List<Result> resultsSpain = getResults(matches, "Spain");
//        resultsSpain.forEach(System.out::println);

//        System.out.println();
//        System.out.println();

        int sumPointsPoland = sumPoints(resultsPoland);
        int sumGoalsForPoland = sumGoalsFor(resultsPoland);
        int sumGoalsAgainstPoland = sumGoalsAgainst(resultsPoland);
        int sumGoalsDifferencePoland = sumGoalsDifference(resultsPoland);
        List<Result> statsPoland = statsResults("Poland", sumPointsPoland, sumGoalsForPoland,
                sumGoalsAgainstPoland, sumGoalsDifferencePoland);

//        statsPoland.forEach(System.out::println);
//        System.out.println();


        int sumPointsItaly = sumPoints(resultsItaly);
        int sumGoalsForItaly = sumGoalsFor(resultsItaly);
        int sumGoalsAgainstItaly = sumGoalsAgainst(resultsItaly);
        int sumGoalsDifferenceItaly = sumGoalsDifference(resultsItaly);
        List<Result> statsItaly = statsResults("Italy", sumPointsItaly, sumGoalsForItaly,
                sumGoalsAgainstItaly, sumGoalsDifferenceItaly);

//        statsItaly.forEach(System.out::println);
//        System.out.println();

        int sumPointsGermany = sumPoints(resultsGermany);
        int sumGoalsForGermany = sumGoalsFor(resultsGermany);
        int sumGoalsAgainstGermany = sumGoalsAgainst(resultsGermany);
        int sumGoalsDifferenceGermany = sumGoalsDifference(resultsGermany);
        List<Result> statsGermany = statsResults("Germany", sumPointsGermany, sumGoalsForGermany,
                sumGoalsAgainstGermany, sumGoalsDifferenceGermany);

//        statsGermany.forEach(System.out::println);
//        System.out.println();

        int sumPointsSpain = sumPoints(resultsSpain);
        int sumGoalsForSpain = sumGoalsFor(resultsSpain);
        int sumGoalsAgainstSpain = sumGoalsAgainst(resultsSpain);
        int sumGoalsDifferenceSpain = sumGoalsDifference(resultsSpain);
        List<Result> statsSpain = statsResults("Spain", sumPointsSpain, sumGoalsForSpain,
                sumGoalsAgainstSpain, sumGoalsDifferenceSpain);

//        statsSpain.forEach(System.out::println);
//        System.out.println();

        List<Result> standings = new ArrayList<>();
        standings.addAll(statsPoland);
        standings.addAll(statsItaly);
        standings.addAll(statsGermany);
        standings.addAll(statsSpain);

//        standings.forEach(System.out::println);


        System.out.println();
        System.out.println("Standings");
        List<Result> finalStandings = sortResults(standings);

        printStandingsShortcuts();
        finalStandings.forEach(System.out::println);
    }

    private static void printStandingsShortcuts() {
        System.out.printf("%-10s %-3s %-3s %-3s %-3s\n", "Team", "Pts", "GF", "GA", "GD");
    }

    private static List<String> teams() {
        List<String> teams = new ArrayList<>();
        teams.add("Poland");
        teams.add("Italy");
        teams.add("Germany");
        teams.add("Spain");
        return teams;
    }


    private static List<Match> scores(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size() ; j++) {
                Match match = new Match(teams.get(i), teams.get(j), random.nextInt(upperbound),
                        random.nextInt(upperbound));
                matches.add(match);
            }
        }
        return matches;
    }

    private static List<Result> getResults(List<Match> matches, String name) {
        List<Result> results = new ArrayList<>();
        for (Match match : matches) {
            if (name.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                results.add(new Result(name, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
            } else if (name.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                results.add(new Result(name, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
            } else if (name.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                results.add(new Result(name, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
            } else if (name.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                results.add(new Result(name, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
            } else if (name.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                results.add(new Result(name, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
            } else if (name.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                results.add(new Result(name, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
            }
        }
        return results;
    }


    private static int sumPoints(List<Result> list) {
        return list.stream()
                .mapToInt(Result::getPoints)
                .sum();
    }

    private static int sumGoalsFor(List<Result> list) {
        return list.stream()
                .mapToInt(Result::getGoalsFor)
                .sum();
    }

    private static int sumGoalsAgainst(List<Result> list) {
        return list.stream()
                .mapToInt(Result::getGoalsAgainst)
                .sum();
    }

    private static int sumGoalsDifference(List<Result> list) {
        return list.stream()
                .mapToInt(Result::getGoalsDifference)
                .sum();
    }

    private static List<Result> statsResults(String name, int point, int goalsFor,
                                             int goalsAgainst, int goalsDifference) {
        List<Result> results = new ArrayList<>();
        Result result = new Result(name, point, goalsFor, goalsAgainst, goalsDifference);
        results.add(result);
        return results;
    }

    private static List<Result> sortResults(List<Result> list) {
        return list.stream()
                .sorted(Comparator.comparing(Result::getPoints)
                .thenComparing(Result::getGoalsDifference)
                .thenComparing(Result::getGoalsFor)
                .thenComparing(Result::getGoalsAgainst).reversed())
                .collect(Collectors.toList());
    }

//    private static List<Result> printTable(List<Result> list) {
//        Comparator<Result> comparator = Comparator.comparing(Result::getPoints).reversed();
//        comparator = comparator.thenComparing(Result::getGoalsDifference);
//        comparator = comparator.thenComparing(Result::getGoalsFor);
//        comparator = comparator.thenComparing(Result::getGoalsAgainst);
//        return list.stream()
//                .sorted(comparator)
//                .collect(Collectors.toList());
//    }
}
