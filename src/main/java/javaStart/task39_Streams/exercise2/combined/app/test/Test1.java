package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    private static Scanner input = new Scanner(System.in);
    private static List<String> teamsList = new ArrayList<>();
    private static Map<Result, List<Result>> teamsMap = new HashMap<>();
    private static List<Result> results = new ArrayList<>();

    public static void main(String[] args) {
        int numbers =  numbersTeams();
        printLine("" + numbers);
        teamsList = addTeams(numbers);
        teamsList.forEach(System.out::println);
        List<Match> matches = createScores(teamsList);
        matches.forEach(System.out::println);

        results = getResults(matches, teamsList);
        results.forEach(System.out::println);

        teamsMap = grouping(results);

        printMap(teamsMap);

        System.out.println();
        System.out.println();

        results = new ArrayList<>(teamsMap.keySet());
        System.out.println("List before sorting");
        results.forEach(System.out::println);


        System.out.println();

        results = sorting(results);
        System.out.println("List after sorting");
        results.forEach(System.out::println);
    }

    private static List<Result> sorting(List<Result> results) {
        return results.stream()
                .sorted(Comparator.comparing(Result::getPoints)
                        .thenComparing(Result::getGoalsFor)
                        .thenComparing(Result::getGoalsAgainst)
                        .thenComparing(Result::getGoalsDifference).reversed())
                .collect(Collectors.toList());
    }

    private static void printMap(Map<Result, List<Result>> map) {
        System.out.println();
        for (Map.Entry<Result, List<Result>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    private static Map<Result, List<Result>> grouping(List<Result> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Result::getName))
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> {
                    int sumPoints = entry.getValue().stream().mapToInt(Result::getPoints).sum();
                    int sumGoalsFor = entry.getValue().stream().mapToInt(Result::getGoalsFor).sum();
                    int sumGoalsAgainst = entry.getValue().stream().mapToInt(Result::getGoalsAgainst).sum();
                    int sumGoalsDifference = entry.getValue().stream().mapToInt(Result::getGoalsDifference).sum();
                    return new Result(entry.getKey(), sumPoints, sumGoalsFor, sumGoalsAgainst, sumGoalsDifference);
                }, Map.Entry::getValue));
    }

    //inny sposób na grupowanie
//            Map<Result, List<Result>> map = results.stream()
//                .collect(Collectors.groupingBy(Result::getName))
//                .entrySet().stream()
//                .collect(Collectors.toMap(e -> e.getValue().stream().collect(
//                        Collectors.reducing((l, r) -> new Result(l.getName(),
//                                l.getPoints() + r.getPoints(),
//                                l.getGoalsFor() + r.getGoalsFor(),
//                                l.getGoalsAgainst() + r.getGoalsAgainst(),
//                                l.getGoalsDifference() + r.getGoalsDifference())))
//                                .get(),
//                        e -> e.getValue()));
//
//        System.out.println(map);

    private static Map<String, Integer> getPoints(List<Result> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Result::getName, Collectors.summingInt(Result::getPoints)));
    }

    private static Map<String, Integer> getGoalsFor(List<Result> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Result::getName, Collectors.summingInt(Result::getGoalsFor)));
    }

    private static Map<String, Integer> getGoalsAgainst(List<Result> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Result::getName, Collectors.summingInt(Result::getGoalsAgainst)));
    }

    private static Map<String, Integer> getGoalsDifference(List<Result> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Result::getName, Collectors.summingInt(Result::getGoalsDifference)));

    }

    private static int sumPoints(List<Result> results) {
        return results.stream()
                .mapToInt(Result::getPoints)
                .sum();
    }

    private static int sumGoalsFor(List<Result> results) {
        return results.stream()
                .mapToInt(Result::getGoalsFor)
                .sum();
    }

    private static int sumGoalsAgainst(List<Result> results) {
        return results.stream()
                .mapToInt(Result::getGoalsAgainst)
                .sum();
    }

    private static int sumGoalsDifference(List<Result> results) {
        return results.stream()
                .mapToInt(Result::getGoalsDifference)
                .sum();
    }

    private static List<Result> getResults(List<Match> matches, List<String> teams) {
        List<Result> results = new ArrayList<>();
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    results.add(new Result(team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    results.add(new Result(team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    results.add(new Result(team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                        match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    results.add(new Result(team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    results.add(new Result(team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    results.add(new Result(team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                        match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return results;
    }

    private static List<Match> createScores(List<String> teams) {
        List<Match> matches = new ArrayList<>();
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j), random.nextInt(upperbound), random.nextInt(upperbound));
                matches.add(match);
            }
        }
        return matches;
    }

    private static List<String> addTeams(int numberTeam) {
        String team;
            while (teamsList.size() < numberTeam) {
                try {
                    team = createTeam();
                    checkDuplicate(team);
                    teamsList.add(team);
                } catch (TeamDuplicateException e) {
                    e.getMessage();
                }
            }
        return teamsList;
    }

    private static int numbersTeams() {
        printLine("Enter number of teams");
        return getNumber();
    }

    private static String createTeam() {
        printLine("Enter the name of team");
        return input.nextLine();
    }

    private static int getNumber() {
        boolean numberOk = false;
        int number = 0;
        while (!numberOk) {
            try {
                number = input.nextInt();
                number = checkPositive(number);
                numberOk = true;
            } catch (InputMismatchException e) {
                printLineError("Enter digit, try again");
            } catch (NumberPositiveException e) {
                e.getMessage();
            } finally {
                clearBuffer();
            }
        }
        return number;
    }

    private static int checkPositive(int number) {
        if (number <= 0) {
            throw new NumberPositiveException("Enter positive number, try again");
        }
        return number;
    }

    private static class NumberPositiveException extends RuntimeException {
        public NumberPositiveException(String message) {
            System.err.println(message);
        }
    }

    private static void checkDuplicate(String team) {
            for (int i = 0; i < teamsList.size(); i++)
                if (teamsList.get(i).equals(team)) {
                    throw new TeamDuplicateException("Team with given name exists already, try again");
                }
    }

    private static class TeamDuplicateException extends RuntimeException {
        public TeamDuplicateException(String message) {
            System.err.println(message);
        }
    }

    private static class Match {
        private String homeTeam;
        private String awayTeam;
        private int homeTeamGoal;
        private int awayTeamGoal;

        public Match(String homeTeam, String awayTeam, int homeTeamGoal, int awayTeamGoal) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.homeTeamGoal = homeTeamGoal;
            this.awayTeamGoal = awayTeamGoal;
        }

        public String getHomeTeam() {
            return homeTeam;
        }

        public String getAwayTeam() {
            return awayTeam;
        }

        public int getHomeTeamGoal() {
            return homeTeamGoal;
        }

        public int getAwayTeamGoal() {
            return awayTeamGoal;
        }

        @Override
        public String toString() {
            return homeTeam + " - " + awayTeam + " (" + homeTeamGoal + ":" + awayTeamGoal + ")";
        }
    }

    private static class Result {
        private String name;
        private int points;
        private int goalsFor;
        private int goalsAgainst;
        private int goalsDifference;

        public Result(String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
            this.name = name;
            this.points = points;
            this.goalsFor = goalsFor;
            this.goalsAgainst = goalsAgainst;
            this.goalsDifference = goalsDifference;
        }

        public String getName() {
            return name;
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

        @Override
        public String toString() {
            return String.format("%-10s %-3s %-3s %-3s %-3s", name, points, goalsFor, goalsAgainst, goalsDifference);
        }
    }

    private static void clearBuffer() {
        input.nextLine();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void printLineError(String text) {
        System.err.println(text);
    }



//
//    private static List<Result> getName(List<Result> results, List<String> teams) {
//        List<Result> resultsAfterSum = new ArrayList<>();
//        int sumPoints = 0;
//        int sumGoalsFor = 0;
//        int sumGoalsAgainst = 0;
//        int sumGoalsDifference = 0;
//        int counter = 0;
//        for (int i = 0; i < teams.size(); i++) {
//            for (int j = 0; j < results.size(); j++) {
//                if (counter == teams.indexOf(teams.get(i))) {
//                    String teamName = teams.get(i);
//                    if (teamName.equals(results.get(j).getName())) {
//                        sumPoints += results.get(j).getPoints();
//                        sumGoalsFor += results.get(j).getGoalsFor();
//                        sumGoalsAgainst += results.get(j).getGoalsAgainst();
//                        sumGoalsDifference += results.get(j).getGoalsDifference();
//                        resultsAfterSum.add(new Result(results.get(j).getName(), sumPoints,
//                                sumGoalsFor, sumGoalsAgainst, sumGoalsDifference));
//
//                    }
//                }
//            }
//            counter++;
//        }
//        return resultsAfterSum;
//    }

//    private static List<Result> getName(List<Result> results, List<String> teams) {
//        List<Result> resultsAfterSum = new ArrayList<>();
//        int sumPoints = 0;
//        int sumGoalsFor = 0;
//        int sumGoalsAgainst = 0;
//        int sumGoalsDifference = 0;
//        int counter = 0;
//        for (int i = 0; i < teams.size(); i++) {
//            for (Result result : results) {
//                if (counter == teams.indexOf(teams.get(i))) {
//                    sumPoints += result.getPoints();
//                    sumGoalsFor += result.getGoalsFor();
//                    sumGoalsAgainst += result.getGoalsAgainst();
//                    sumGoalsDifference += result.getGoalsDifference();
//                    resultsAfterSum.add(new Result(result.getName(), sumPoints,
//                            sumGoalsFor, sumGoalsAgainst, sumGoalsDifference));
//                }
//            }
//            counter++;
//        }
//        return resultsAfterSum;
//    }
}
