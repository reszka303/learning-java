package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    private static Scanner input = new Scanner(System.in);
    private static List<String> teamsList = new ArrayList<>();
    private static List<Match> matches = new ArrayList<>();
    private static Map<Result, List<Result>> teamsMap = new HashMap<>();

    private static List<Result> results = new ArrayList<>();

    public static void main(String[] args) {
        int numbers =  getNumbersTeams();
        printLine("" + numbers);
        teamsList = addTeams(numbers);
        teamsList.forEach(System.out::println);
        List<String> namesTeam = teamsList;
        System.out.println();
        matches = createScores(teamsList);
        matches.forEach(System.out::println);

        List<Match> matchesToOne = matches;

        System.out.println();

        System.out.println("Home away");
        List<Match> homeTeam = sortByHomeGoals(matches);
        homeTeam.forEach(System.out::println);
        System.out.println();

        List<Match> tied = sortByTied(matches);
        System.out.println("Tied");
        tied.forEach(System.out::println);
        System.out.println();

        List<Match> awayTeam = sortByAwayTeam(matches);
        System.out.println("AwayTeam");
        awayTeam.forEach(System.out::println);
        System.out.println();

        System.out.println();
        List<Match> combinedList = addAllToList(homeTeam, tied, awayTeam);
        System.out.println("List combined");
        combinedList.forEach(System.out::println);

        System.out.println();

        System.out.println("List of Teams:");
        teamsList.forEach(System.out::println);
        System.out.println();
        String team = getTeam(namesTeam);
        List<Match> matchesOneTeam = sortByTeam(matchesToOne, team);
        System.out.println("All matches one team");
        matchesOneTeam.forEach(System.out::println);
        System.out.println();

        results = getResults(matches, teamsList);
        results.forEach(System.out::println);

        teamsMap = group(results);

        printMap(teamsMap);

        System.out.println();
        System.out.println();

        long teamNumbers = countByTeams(teamsList);
        System.out.println("The team numbers is: " + teamNumbers);

        long teamNumbersMap = countByTeamsHashMap(teamsMap);
        System.out.println("The team numbers in map is: " + teamNumbersMap);

        long goalsNumbers = countByGoals(matches);
        System.out.println("The goals numbers is:" + goalsNumbers);

        results = new ArrayList<>(teamsMap.keySet());
        System.out.println("List before sorting");
        results.forEach(System.out::println);


        System.out.println();

        results = sortByGoals(results);
        System.out.println("List after sorting");
        results.forEach(System.out::println);
    }

    private static long countByGoals(List<Match> matches) {
        return matches.stream()
                .mapToInt(Match::getGoalsSum)
                .sum();
    }

    private static long countByTeamsHashMap(Map<Result, List<Result>> map) {
        return map.keySet().stream()
                .map(Result::getTeams)
                .mapToLong(List::size)
                .sum();
    }

    private static long countByTeams(List<String> names) {
        return names.size();
    }

    private static List<Match> sortByTeam(List<Match> matches, String team) {
        return matches.stream()
                .filter(match -> match.getHomeTeam().contains(team)
                        || match.getAwayTeam().contains(team))
                .collect(Collectors.toList());
    }

    private static String getTeam(List<String> teams) {
        String name = "";
        boolean teamOk = false;
        int counter = 0;
        while (!teamOk) {
            try {
                printLine("Enter a name of a team to display its all matches");
                name = input.nextLine().toLowerCase();
                for (String team : teams) {
                    if (team.equals(name)) {
                        counter++;
                    }
                }
                if (counter == 1) {
                    teamOk = true;
                }
                if (counter == 0) {
                    throw new TeamNotFoundException("There is no team with given name, try again");
                }
            } catch (TeamNotFoundException e) {
                e.getMessage();
            }
        }
        return name;
    }

    private static List<Match> addAllToList(List<Match> list1, List<Match> list2, List<Match> list3) {
        return Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Match> sortByAwayTeam(List<Match> matches) {
        return matches.stream()
                .filter(Match::awayTeamScores)
                .sorted(Comparator.comparing(Match::getAwayTeamGoal)
                        .thenComparing(Match::getHomeTeamGoal))
                .collect(Collectors.toList());
    }

    private static List<Match> sortByTied(List<Match> matches) {
        return matches.stream()
                .filter(Match::tiedScore)
                .sorted(Comparator.comparing(Match::getHomeTeamGoal)
                        .thenComparing(Match::getAwayTeam).reversed())
                .collect(Collectors.toList());
    }

    private static List<Match> sortByHomeGoals(List<Match> matches) {
        return matches.stream()
                .filter(Match::homeTeamScores)
                .sorted(Comparator.comparing(Match::getHomeTeamGoal).reversed())
                .collect(Collectors.toList());
    }

    private static List<Result> sortByGoals(List<Result> results) {
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

    private static Map<Result, List<Result>> group(List<Result> results) {
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

    private static int getNumbersTeams() {
        printLine("Enter number of teams");
        return getNumber();
    }

    private static String createTeam() {
        printLine("Enter the name of team");
        return input.nextLine().toLowerCase();
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

    private static class TeamNotFoundException extends RuntimeException {
        public TeamNotFoundException(String message) {
            printLineError(message);
        }
    }

    private static void checkDuplicate(String name) {
        for (String team : teamsList)
            if (team.equals(name)) {
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

        private boolean homeTeamScores() {
            return homeTeamGoal > awayTeamGoal;
        }

        private boolean tiedScore() {
            return homeTeamGoal == awayTeamGoal;
        }

        private boolean awayTeamScores() {
            return homeTeamGoal < awayTeamGoal;
        }

        private List<String> getTeamList() {
            return List.of(homeTeam, awayTeam);
        }

        private int getGoalsSum() {
            return homeTeamGoal + awayTeamGoal;
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

        private List<String> getTeams() {
            return List.of(name);
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
}
