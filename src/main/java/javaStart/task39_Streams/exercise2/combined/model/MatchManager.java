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
    private List<Match> matchFirstRound = new ArrayList<>();
    private List<Match> matchRematch = new ArrayList<>();
    private List<Scoring> scoringFirstRound = new ArrayList<>();
    private List<Scoring> scoringRematch = new ArrayList<>();
    private Map<Scoring, List<Scoring>> scoringFirstRoundListMap = new HashMap<>();
    private Map<Scoring, List<Scoring>> scoringRematchListMap = new HashMap<>();
    private String team;

    public List<String> getTeams() {
        return teams;
    }

    public List<Match> getMatchFirstRound() {
        return matchFirstRound;
    }

    public List<Match> getMatchRematch() {
        return matchRematch;
    }

    public List<Scoring> getScoringFirstRound() {
        return scoringFirstRound;
    }

    public List<Scoring> getScoringRematch() {
        return scoringRematch;
    }

    public Map<Scoring, List<Scoring>> getScoringFirstRoundListMap() {
        return scoringFirstRoundListMap;
    }

    public Map<Scoring, List<Scoring>> getScoringRematchListMap() {
        return scoringRematchListMap;
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

    public List<Match> createFirstRound(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchFirstRound.add(match);
            }
        }
        return matchFirstRound;
    }

    public List<Match> createRematch(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(j), teams.get(i),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchRematch.add(match);
            }
        }
        return matchRematch;
    }

    public List<Scoring> createScoring(List<Match> matches, List<String> teams, List<Scoring> scoringRematch) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematch.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematch.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematch.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematch.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematch.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematch.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringRematch;
    }

    public Map<Scoring, List<Scoring>> groupByName(List<Scoring> scoring) {
//        Map<Scoring, List<Scoring>> scoringListMap = new HashMap<>();
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

    public List<Scoring> getKey(Map<Scoring, List<Scoring>> map) {
        return new ArrayList<>(map.keySet());
    }


    public List<Scoring> sortByPointsAndGoals(List<Scoring> scoring) {
        return scoring.stream()
                .sorted(Comparator.comparing(Scoring::getPoints)
                        .thenComparing(Scoring::getGoalsFor).reversed()
                        .thenComparing(Scoring::getGoalsAgainst)
                        .thenComparing((Scoring::getGoalsDifference)))
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

    public List<Match> sortByWinnersAwayTeam(List<Match> matches) {
        return matches.stream()
                .filter(Match::getWinnersAwayTeam)
                .sorted(Comparator.comparing(Match::getAwayTeamGoal))
                .collect(Collectors.toList());
    }

    public List<Scoring> increasePosition(List<Scoring> scorings) {
        int counter = 0;
        for (int i = 0; i < scorings.size(); i++) {
            if (i == counter) {
                scorings.get(i).setPosition(scorings.get(i).getPosition() + counter);
            }
            counter++;
        }
        return scorings;
    }

    public List<Match> joinWinTieLoss(List<Match> wins, List<Match> ties, List<Match> losses) {
        return Stream.of(wins, ties, losses)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Match> joinAllSortedMatchesByWinTiesLoss(List<Match> firstRoundMatches, List<Match> rematches) {
        return Stream.of(firstRoundMatches, rematches)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Scoring> joinFirstRoundAndRematches(List<Scoring> scoringFirstRound, List<Scoring> rematches) {
            return Stream.of(scoringFirstRound, rematches)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
    }

    public String getTeam(List<String> teams) {
        boolean teamOk = false;
        team = null;
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

    public int countByTeams(List<String> teams) {
        return teams.size();
    }

    public long countByGoals(List<Match> matches) {
        return matches.stream()
                .mapToLong(Match::getGoalsHomeAndAwayTeams)
                .sum();
    }
}
