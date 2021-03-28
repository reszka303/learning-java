package javaStart.task39_Streams.exercise2.extended;

import java.util.*;
import java.util.stream.Collectors;

public class MatchManager{
    public static void main(String[] args) {
        List<String> teams = teams();
        List<Match> matches = scores(teams);
        System.out.println("Results");
        matches.forEach(System.out::println);
        System.out.println();

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

        List<Result> resultsSweden = getResults(matches, "Sweden");

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

        int sumPointsSweden = sumPoints(resultsSweden);
        int sumGoalsForSweden = sumGoalsFor(resultsSweden);
        int sumGoalsAgainstSweden = sumGoalsAgainst(resultsSweden);
        int sumGoalsDifferenceSweden = sumGoalsDifference(resultsSweden);
        List<Result> statsSweden = statsResults("Sweden", sumPointsSweden, sumGoalsForSweden,
                sumGoalsAgainstSweden, sumGoalsDifferenceSweden);

//        statsSpain.forEach(System.out::println);
//        System.out.println();

        List<Result> standings = new ArrayList<>();
        standings.addAll(statsPoland);
        standings.addAll(statsItaly);
        standings.addAll(statsGermany);
        standings.addAll(statsSpain);
        standings.addAll(statsSweden);

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
        teams.add("Sweden");
        return teams;
    }


//    private static List<Match> scores(List<String> teams) {
//        Random random = new Random();
//        int upperbound = 5;
//        List<Match> matches = new ArrayList<>();
//        for (int i = 0; i < teams.size() - 1; i++) {
//            for (int j = i + 1; j < teams.size() ; j++) {
//                Match match = new Match(teams.get(i), teams.get(j), random.nextInt(upperbound),
//                        random.nextInt(upperbound));
//                matches.add(match);
//            }
//        }
//        return matches;
//    }

    private static List<Match> scores(List<String> teams) {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match(teams.get(0), teams.get(1), 1, 1));
        matches.add(new Match(teams.get(0), teams.get(2), 8,4));
        matches.add(new Match(teams.get(0), teams.get(3), 4, 4));
        matches.add(new Match(teams.get(0), teams.get(4), 4, 4));
        matches.add(new Match(teams.get(1), teams.get(2), 4, 4));
        matches.add(new Match(teams.get(1), teams.get(3), 8, 5));
        matches.add(new Match(teams.get(1), teams.get(4), 8, 5));
        matches.add(new Match(teams.get(2), teams.get(3), 2, 2));
        matches.add(new Match(teams.get(2), teams.get(4), 3, 3));
        matches.add(new Match(teams.get(3), teams.get(4), 2, 2));

        return matches;

//        Match polandItaly = new Match(teams.get(0), teams.get(1), 1, 1);
//        Match polandGermany = new Match(teams.get(0), teams.get(2), 1,2);
//        Match polandSpain = new Match(teams.get(0), teams.get(3), 1, 3);
//        Match italyGermany = new Match(teams.get(1), teams.get(1), 1, 3);
//        Match italySpain  = new Match(teams.get(1), teams.get(3), 1, 3);
//        Match germanySpain  = new Match(teams.get(2), teams.get(3), 1, 3);

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
                        .thenComparing(Result::getGoalsFor).reversed()
                        .thenComparing(Result::getGoalsAgainst)
                        .thenComparing((Result::getGoalsDifference)))
                .collect(Collectors.toList());
    }

//    private static List<Result> sortResults(List<Result> list) {
//        return list.stream()
//                .sorted(Comparator.comparing(Result::getGoalsFor)
//                        .thenComparing(Result::getGoalsAgainst).reversed()
//                        .thenComparing((Result::getGoalsDifference)))
//                .collect(Collectors.toList());
//    }

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
