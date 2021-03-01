package javaStart.task39_Streams.exercise2.extended;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
//        List<String> teams = teams();
//        List<Match> matches = scores(teams);
//        matches.forEach(System.out::println);
//        List<Result> resultsHomeTeam = new ArrayList<>();
//        List<Result> resultsAwayTeam = new ArrayList<>();

        //wyszukujemy druzyne czy jest gospodarzem czy gosciem
//        List<Result> homeResultsItaly = matchesHomeTeam(matches, resultsHomeTeam, "Italy");
//        List<Result> awayResultsItaly = matchesAwayTeam(matches, resultsAwayTeam, "Italy");
//        homeResultsItaly.forEach(System.out::println);
//        awayResultsItaly.forEach(System.out::println);


//        List<Result> homeResultsPoland = matchesHomeTeam(matches, resultsHomeTeam, "Poland");
//        List<Result> awayResultsPoland = matchesAwayTeam(matches, resultsAwayTeam, "Poland");
//        homeResultsPoland.forEach(System.out::println);
//        awayResultsPoland.forEach(System.out::println);

//        List<Result> homeResultsGermany = matchesHomeTeam(matches, resultsHomeTeam, "Germany");
//        List<Result> awayResultsGermany = matchesAwayTeam(matches, resultsAwayTeam, "Germany");
//        homeResultsGermany.forEach(System.out::println);
//        awayResultsGermany.forEach(System.out::println);

//        List<Result> homeResultsSpain = matchesHomeTeam(matches, resultsHomeTeam, "Spain");
//        List<Result> awayResultsSpain = matchesAwayTeam(matches, resultsAwayTeam, "Spain");
//        homeResultsSpain.forEach(System.out::println);
//        awayResultsSpain.forEach(System.out::println);



        //dodajemy liste gospodarzy i gosci
//        List<Result> italyResults = new ArrayList<>();
//        italyResults.addAll(homeResultsItaly);
//        italyResults.addAll(awayResultsItaly);
//        italyResults.forEach(System.out::println);
//        System.out.println();
//        System.out.println();

//        List<Result> polandResults = new ArrayList<>();
//        polandResults.addAll(homeResultsPoland);
//        polandResults.addAll(awayResultsPoland);
//
//        List<Result> germanyResults = new ArrayList<>();
//        germanyResults.addAll(homeResultsGermany);
//        germanyResults.addAll(awayResultsGermany);
//
//        List<Result> spainResults = new ArrayList<>();
//        spainResults.addAll(homeResultsSpain);
//        spainResults.addAll(awayResultsSpain);


        //pobieramy wylacznie wyniki, obcinanie strina
//        List<PointsAndGoals> pointsAndGoalsItaly =  getStatsMatch(italyResults);
//        pointsAndGoalsItaly.forEach(System.out::println);

//        List<PointsAndGoals> pointsAndGoalsPoland =  getStatsMatch(polandResults);
//        List<PointsAndGoals> pointsAndGoalsGermany =  getStatsMatch(germanyResults);
//        List<PointsAndGoals> pointsAndGoalsSpain =  getStatsMatch(spainResults);


        //tworzenie elementow po z sumowaniu statystyk meczowych
//        String italy = "Italy";
//        int pointItaly = sumPointStream(pointsAndGoalsItaly);
//        int goalsForItaly = sumGoalsFor(pointsAndGoalsItaly);
//        int goalsAgainstItaly = sumGoalsAgainst(pointsAndGoalsItaly);
//        int goalsDifferenceItaly = sumGoalsDifference(pointsAndGoalsItaly);

//        String poland = "Poland";
//        int pointPoland = sumPointStream(pointsAndGoalsPoland);
//        int goalsForPoland = sumGoalsFor(pointsAndGoalsPoland);
//        int goalsAgainstPoland = sumGoalsAgainst(pointsAndGoalsPoland);
//        int goalsDifferencePoland = sumGoalsDifference(pointsAndGoalsPoland);
//
//        String germany = "Germany";
//        int pointGermany = sumPointStream(pointsAndGoalsGermany);
//        int goalsForGermany = sumGoalsFor(pointsAndGoalsGermany);
//        int goalsAgainstGermany = sumGoalsAgainst(pointsAndGoalsGermany);
//        int goalsDifferenceGermany = sumGoalsDifference(pointsAndGoalsGermany);
//
//        String spain = "Spain";
//        int pointSpain = sumPointStream(pointsAndGoalsSpain);
//        int goalsForSpain = sumGoalsFor(pointsAndGoalsSpain);
//        int goalsAgainstSpain = sumGoalsAgainst(pointsAndGoalsSpain);
//        int goalsDifferenceSpain = sumGoalsDifference(pointsAndGoalsSpain);


        //wyswietlanie danych
//        System.out.println("Point: " + pointItaly);
//        System.out.println("GoalsFor: " + goalsForItaly);
//        System.out.println("GoalsAgainst: " + goalsAgainstItaly);
//        System.out.println("GoalsDifference: " + goalsDifferenceItaly);

        //tworzenie tablicy z druzyna i jej wynikami
//        List<Result> finalResultItaly = getResult(italy, pointItaly, goalsForItaly,
//                goalsAgainstItaly, goalsDifferenceItaly);
//        finalResultItaly.forEach(System.out::println);

//        List<Result> finalResultPoland = getResult(poland, pointPoland, goalsForPoland,
//                goalsAgainstPoland, goalsDifferencePoland);
//
//        List<Result> finalResultGermany = getResult(germany, pointGermany, goalsForGermany,
//                goalsAgainstGermany, goalsDifferenceGermany);
//
//        List<Result> finalResultSpain = getResult(spain, pointSpain, goalsForSpain,
//                goalsAgainstSpain, goalsDifferenceSpain);

//        List<Result> finalAllTeams = new ArrayList<>();
//        finalAllTeams.addAll(finalResultItaly);
//        finalAllTeams.addAll(finalResultPoland);
//        finalAllTeams.addAll(finalResultGermany);
//        finalAllTeams.addAll(finalResultSpain);

//        finalAllTeams.forEach(System.out::println);


    }

//    private static List<String> teams() {
//        List<String> teams = new ArrayList<>();
//        teams.add("Poland");
//        teams.add("Italy");
//        teams.add("Germany");
//        teams.add("Spain");
//        return teams;
//    }

//    private static List<Match> scores(List<String> list) {
//        Random random = new Random();
//        int upperbound = 5;
//        List<Match> matches = new ArrayList<>();
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = i + 1; j < list.size() ; j++) {
//                Match match = new Match(list.get(i), list.get(j), random.nextInt(upperbound),
//                        random.nextInt(upperbound));
//                matches.add(match);
//            }
//        }
//        return matches;
//    }

//    private static List<Result> matchesHomeTeam(List<Match> list, List<Result> result, String team) {
//        for (Match match : list) {
//            if (match.getHomeTeamGoal() > match.getAwayTeamGoal() && team.equals(match.getHomeTeam())) {
//                result.add(new Result(team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
//                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
//            } if (match.getHomeTeamGoal() == match.getAwayTeamGoal() && team.equals(match.getHomeTeam())) {
//                result.add(new Result(team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
//                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
//            } if (match.getHomeTeamGoal() < match.getAwayTeamGoal() && team.equals(match.getHomeTeam())) {
//                result.add(new Result(team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
//                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
//            }
//
//        }
//        return result;
//    }

//    private static List<Result> matchesAwayTeam(List<Match> list, List<Result> result, String team) {
//        for (Match match : list) {
//            if (match.getHomeTeamGoal() < match.getAwayTeamGoal() && team.equals(match.getAwayTeam())) {
//                result.add(new Result(team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
//                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
//            } if (match.getHomeTeamGoal() == match.getAwayTeamGoal() && team.equals(match.getAwayTeam())) {
//                result.add(new Result(team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
//                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
//            } if (match.getHomeTeamGoal() > match.getAwayTeamGoal() && team.equals(match.getAwayTeam())) {
//                result.add(new Result(team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
//                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
//            }
//        }
//        return result;
//    }

//    private static List<Result> matchesHomeTeam(List<Match> list, List<Result> result, String team) {
//        for (Match match : list) {
//            if (recognizeHomeTeam(team, match)) {
//                if (match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
//                    result.add(new Result(team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
//                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
//                } else if (match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
//                    result.add(new Result(team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
//                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
//                } else if (match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
//                    result.add(new Result(team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
//                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
//                }
//            }
//        }
//        return result;
//    }
//
//
//
//    private static List<Result> matchesAwayTeam(List<Match> list, List<Result> result, String team) {
//        for (Match match : list) {
//            if (recognizeAwayTeam(team, match)) {
//                if (match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
//                    result.add(new Result(team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
//                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
//                } else if (match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
//                    result.add(new Result(team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
//                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
//                } else if (match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
//                    result.add(new Result(team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
//                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
//                }
//            }
//        }
//        return result;
//    }

//    private static boolean recognizeHomeTeam(String team, Match match) {
//        return match.getHomeTeam().equals(team);
//    }
//
//    private static boolean recognizeAwayTeam(String team, Match match) {
//        return match.getAwayTeam().equals(team);
//    }
//
//    private static List<PointsAndGoals> getStatsMatch(List<Result> list) {
//        List<PointsAndGoals> pointsAndGoalHomes = new ArrayList<>();
//        for (Result result : list) {
//            pointsAndGoalHomes.add(new PointsAndGoals(result.getPoints(), result.getGoalsFor(),
//                    result.getGoalsAgainst(), result.getGoalsDifference()));
//        }
//        return pointsAndGoalHomes;
//    }
//
//    private static int sumPointStream(List<PointsAndGoals> list) {
//        return list.stream()
//                .mapToInt(PointsAndGoals::sumPoint)
//                .sum();
//    }
//
//    private static int sumGoalsFor(List<PointsAndGoals> list) {
//        return list.stream()
//                .mapToInt(PointsAndGoals::sumGoalsFor)
//                .sum();
//    }
//
//    private static int sumGoalsAgainst(List<PointsAndGoals> list) {
//        return list.stream()
//                .mapToInt(PointsAndGoals::sumGoalAgainst)
//                .sum();
//    }
//
//    private static int sumGoalsDifference(List<PointsAndGoals> list) {
//        return list.stream()
//                .mapToInt(PointsAndGoals::sumGoalsDifference)
//                .sum();
//    }
//
//    private static int sumPoint(PointsAndGoals pointsAndGoals) {
//        int sum = 0;
//        return sum + pointsAndGoals.getPoints();
//    }
//
//    private static List<Result> getResult(String team, int points, int goalsFor, int goalsAgainst,
//                                          int goalsDifference) {
//        List<Result> results = new ArrayList<>();
//        results.add(new Result(team, points, goalsFor, goalsAgainst, goalsDifference));
//        return results;
//    }
}
