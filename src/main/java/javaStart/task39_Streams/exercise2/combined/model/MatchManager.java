package javaStart.task39_Streams.exercise2.combined.model;

import javaStart.task39_Streams.exercise2.combined.exception.TeamDuplicateException;
import javaStart.task39_Streams.exercise2.combined.exception.TeamNotFoundException;
import javaStart.task39_Streams.exercise2.combined.io.ConsolePrinter;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchManager {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private List<String> teams = new ArrayList<>();
    private List<Match> matches = new ArrayList<>();
    private List<Result> results = new ArrayList<>();
    private Map<Result, List<Result>> resultListMap = new HashMap<>();
    private String team;

    public List<String> getTeams() {
        return teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<Result> getResults() {
        return results;
    }

    public Map<Result, List<Result>> getResultListMap() {
        return resultListMap;
    }

    public String getTeam() {
        return team;
    }

    public List<String> addTeams(int numberTeam) {
        String team;
            while (teams.size() < numberTeam) {
                try {
                    team = dataReader.createTeam();
                    checkDuplicate(dataReader.capitalizeFirstLetterEverySingleWord(team));
                    teams.add(dataReader.capitalizeFirstLetterEverySingleWord(team));
                } catch (TeamDuplicateException e) {
                    e.getMessage();
                }
            }
        return teams;
    }

    private void checkDuplicate(String team) {
        for (int i = 0; i < teams.size(); i++)
            if (teams.get(i).equals(team)) {
                throw new TeamDuplicateException("Team with given name exists already, try again");
        }
    }

    public List<Match> createScores(List<String> teams) {
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

    public List<Result> getScores(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    results.add(new Result(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    results.add(new Result(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    results.add(new Result(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    results.add(new Result(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    results.add(new Result(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    results.add(new Result(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return results;
    }

    public Map<Result, List<Result>> groupByName(List<Result> results) {
        return resultListMap = results.stream()
                .collect(Collectors.groupingBy(Result::getName))
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> {
                    int place = 1;
                    int sumPoints = entry.getValue().stream().mapToInt(Result::getPoints).sum();
                    int sumGoalsFor = entry.getValue().stream().mapToInt(Result::getGoalsFor).sum();
                    int sumGoalsAgainst = entry.getValue().stream().mapToInt(Result::getGoalsAgainst).sum();
                    int sumGoalsDifference = entry.getValue().stream().mapToInt(Result::getGoalsDifference).sum();
                    return new Result(place, entry.getKey(), sumPoints, sumGoalsFor, sumGoalsAgainst, sumGoalsDifference);
                }, Map.Entry::getValue));
    }

    public List<Result> getKey(Map<Result, List<Result>> map) {
        return new ArrayList<>(map.keySet());
    }


    public List<Result> sortByPointsAndGoals(List<Result> results) {
        return results.stream()
                .sorted(Comparator.comparing(Result::getPoints)
                        .thenComparing(Result::getGoalsFor).reversed()
                        .thenComparing(Result::getGoalsAgainst)
                        .thenComparing((Result::getGoalsDifference)))
                .collect(Collectors.toList());
    }

    public List<Match> sortByWinnersHomeTeam(List<Match> matches) {
        return matches.stream()
                .filter(Match::getWinnersHomeTeam)
                .sorted(Comparator.comparing(Match::getHomeTeamGoal).reversed())
                .collect(Collectors.toList());
    }

    public List<Match> sortByTies(List<Match> matches) {
        return matches.stream()
                .filter(Match::getTies)
                .sorted(Comparator.comparing(Match::getHomeTeamGoal).reversed())
                .collect(Collectors.toList());
    }

    public List<Result> increasePosition(List<Result> results) {
        int counter = 0;
        for (int i = 0; i < results.size(); i++) {
            if (i == counter) {
                results.get(i).setPosition(results.get(i).getPosition() + counter);
            }
            counter++;
        }
        return results;
    }
    // do wyjaśnienia dlaczego bez strumienia wpisuję counter i liczy od 1, a w przypadku
    //metody peek liczenie zaczyna od 0 + 1 = 1

    public List<Match> sortByWinnersAwayTeam(List<Match> matches) {
        return matches.stream()
                .filter(Match::getWinnersAwayTeam)
                .sorted(Comparator.comparing(Match::getAwayTeamGoal))
                .collect(Collectors.toList());
    }

    public List<Match> combineLists(List<Match> list1, List<Match> list2, List<Match> list3) {
        return Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public String getTeam(List<String> teams) {
        boolean teamOk = false;
        team = null;
//        String team = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                team = dataReader.toLowerCase();
                team = dataReader.capitalizeFirstLetterEverySingleWord(team);
                for (String s : teams) {
                    if (team.equals(s)) {
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
        return team;
    }

    public List<Match> sortByTeam(List<Match> matches, String team) {
        return matches.stream()
                .filter(match -> match.getHomeTeam().contains(team) ||
                        match.getAwayTeam().contains(team))
                .collect(Collectors.toList());
    }

    public long countByTeams(Map<Result, List<Result>> map) {
        return map.keySet().stream()
                .map(Result::getTeams)
                .mapToLong(List::size)
                .sum();
    }

    public long countByGoals(List<Match> matches) {
        return matches.stream()
                .mapToLong(Match::getGoalsHomeAndAwayTeams)
                .sum();
    }
}
