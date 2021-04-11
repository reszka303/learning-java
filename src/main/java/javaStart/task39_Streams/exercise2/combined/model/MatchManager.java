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

    private List<String> teamsUserChoice = new ArrayList<>();
    private List<Match> matchUserChoiceFirstRound = new ArrayList<>();
    private List<Match> matchUserChoiceRematch = new ArrayList<>();
    private List<Match> matchUserChoiceAllMatches = new ArrayList<>();
    private List<Scoring> scoringUserChoiceFirstRound = new ArrayList<>();
    private List<Scoring> scoringUserChoiceRematch = new ArrayList<>();
    private List<Scoring> scoringUserChoiceAllMatches = new ArrayList<>();
    private Map<Scoring, List<Scoring>> mapScoringListMapUserChoiceFirstRound = new HashMap<>();
    private Map<Scoring, List<Scoring>> mapScoringListMapUserChoiceRematch = new HashMap<>();
    private Map<Scoring, List<Scoring>> mapScoringListMapUserChoiceAllMatches = new HashMap<>();
    private String teamUserChoice;

//    private List<String> teamsLaLiga = new ArrayList<>();
//    private List<Match> matchFirstRoundLaLiga = new ArrayList<>();
//    private List<Match> matchRematchLaLiga = new ArrayList<>();
//
//    private List<Match> matchFirstRoundPremierLeague = new ArrayList<>();
//    private List<Match> matchRematchPremierLeague = new ArrayList<>();


    public List<String> getTeamsUserChoice() {
        return teamsUserChoice;
    }

    public List<Match> getMatchUserChoiceFirstRound() {
        return matchUserChoiceFirstRound;
    }

    public List<Match> getMatchUserChoiceRematch() {
        return matchUserChoiceRematch;
    }

    public List<Match> getMatchUserChoiceAllMatches() {
        return matchUserChoiceAllMatches;
    }

    public List<Scoring> getScoringUserChoiceFirstRound() {
        return scoringUserChoiceFirstRound;
    }

    public List<Scoring> getScoringUserChoiceRematch() {
        return scoringUserChoiceRematch;
    }

    public List<Scoring> getScoringUserChoiceAllMatches() {
        return scoringUserChoiceAllMatches;
    }

    public Map<Scoring, List<Scoring>> getMapScoringListMapUserChoiceFirstRound() {
        return mapScoringListMapUserChoiceFirstRound;
    }

    public Map<Scoring, List<Scoring>> getMapScoringListMapUserChoiceRematch() {
        return mapScoringListMapUserChoiceRematch;
    }

    public Map<Scoring, List<Scoring>> getMapScoringListMapUserChoiceAllMatches() {
        return mapScoringListMapUserChoiceAllMatches;
    }

    //    public List<String> getTeamsLaLiga() {
//        return teamsLaLiga;
//    }
//
//    public List<Match> getMatchFirstRoundLaLiga() {
//        return matchFirstRoundLaLiga;
//    }
//
//    public List<Match> getMatchRematchLaLiga() {
//        return matchRematchLaLiga;
//    }
//
//    public List<Match> getMatchFirstRoundPremierLeague() {
//        return matchFirstRoundPremierLeague;
//    }
//
//    public List<Match> getMatchRematchPremierLeague() {
//        return matchRematchPremierLeague;
//    }

    public String getTeamUserChoice() {
        return teamUserChoice;
    }

    public List<String> addTeams(int numberTeam) {
        String team;
            while (teamsUserChoice.size() < numberTeam) {
                try {
                    team = dataReader.createTeam();
                    checkDuplicate(dataReader.capitalizeFirstLetterEverySingleWord(team));
                    teamsUserChoice.add(dataReader.capitalizeFirstLetterEverySingleWord(team));
                } catch (TeamDuplicateException e) {
                    e.getMessage();
                }
            }
        return teamsUserChoice;
    }

    private void checkDuplicate(String team) {
        for (int i = 0; i < teamsUserChoice.size(); i++)
            if (teamsUserChoice.get(i).equals(team)) {
                throw new TeamDuplicateException("Team with given name exists already, try again");
        }
    }

    public List<Match> createFirstRoundUserChoice(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchUserChoiceFirstRound.add(match);
            }
        }
        return matchUserChoiceFirstRound;
    }

    public List<Match> createRematchUserChoice(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(j), teams.get(i),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchUserChoiceRematch.add(match);
            }
        }
        return matchUserChoiceRematch;
    }

//    public List<Match> createFirstRoundLaLiga(List<String> teams) {
//        Random random = new Random();
//        int upperbound = 5;
//        for (int i = 0; i < teams.size() - 1; i++) {
//            for (int j = i + 1; j < teams.size(); j++) {
//                Match match = new Match(teams.get(i), teams.get(j),
//                        random.nextInt(upperbound), random.nextInt(upperbound));
//                matchUserChoiceFirstRound.add(match);
//            }
//        }
//        return matchUserChoiceFirstRound;
//    }
//
//    public List<Match> createRematchLaLiga(List<String> teams) {
//        Random random = new Random();
//        int upperbound = 5;
//        for (int i = 0; i < teams.size() - 1; i++) {
//            for (int j = i + 1; j < teams.size(); j++) {
//                Match match = new Match(teams.get(j), teams.get(i),
//                        random.nextInt(upperbound), random.nextInt(upperbound));
//                matchUserChoiceRematch.add(match);
//            }
//        }
//        return matchUserChoiceRematch;
//    }

//    public List<Match> createFirstRoundPremierLeague(List<String> teams) {
//        Random random = new Random();
//        int upperbound = 5;
//        for (int i = 0; i < teams.size() - 1; i++) {
//            for (int j = i + 1; j < teams.size(); j++) {
//                Match match = new Match(teams.get(i), teams.get(j),
//                        random.nextInt(upperbound), random.nextInt(upperbound));
//                matchUserChoiceFirstRound.add(match);
//            }
//        }
//        return matchUserChoiceFirstRound;
//    }
//
//    public List<Match> createRematchPremierLeague(List<String> teams) {
//        Random random = new Random();
//        int upperbound = 5;
//        for (int i = 0; i < teams.size() - 1; i++) {
//            for (int j = i + 1; j < teams.size(); j++) {
//                Match match = new Match(teams.get(j), teams.get(i),
//                        random.nextInt(upperbound), random.nextInt(upperbound));
//                matchUserChoiceRematch.add(match);
//            }
//        }
//        return matchUserChoiceRematch;
//    }

    public List<Scoring> createScoringUserChoiceFirstRound(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringUserChoiceFirstRound.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringUserChoiceFirstRound.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringUserChoiceFirstRound.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringUserChoiceFirstRound.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringUserChoiceFirstRound.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringUserChoiceFirstRound.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringUserChoiceFirstRound;
    }

    public List<Scoring> createScoringUserChoiceRematch(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringUserChoiceRematch.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringUserChoiceRematch.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringUserChoiceRematch.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringUserChoiceRematch.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringUserChoiceRematch.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringUserChoiceRematch.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringUserChoiceRematch;
    }

    public List<Scoring> createScoringUserChoiceAllMatches(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringUserChoiceAllMatches.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringUserChoiceAllMatches.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringUserChoiceAllMatches.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringUserChoiceAllMatches.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringUserChoiceAllMatches.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringUserChoiceAllMatches.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringUserChoiceAllMatches;
    }

    public Map<Scoring, List<Scoring>> groupByNameScoringUserChoiceFirstRound(List<Scoring> scoring) {
        return  mapScoringListMapUserChoiceFirstRound = scoring.stream()
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

    public Map<Scoring, List<Scoring>> groupByNameScoringUserChoiceRematch(List<Scoring> scoring) {
        return  mapScoringListMapUserChoiceRematch = scoring.stream()
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

    public Map<Scoring, List<Scoring>> groupByNameScoringUserAllMatches(List<Scoring> scoring) {
        return  mapScoringListMapUserChoiceAllMatches = scoring.stream()
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
                .sorted(Comparator.comparing(Match::getAwayTeamGoal).reversed())
                .collect(Collectors.toList());
    }

    public List<Scoring> increasePosition(List<Scoring> scoring) {
        int counter = 0;
        for (int i = 0; i < scoring.size(); i++) {
            if (i == counter) {
                scoring.get(i).setPosition(scoring.get(i).getPosition() + counter);
            }
            counter++;
        }
        return scoring;
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
    public List<Match> joinFirstRoundAndRematches() {
            return matchUserChoiceAllMatches = Stream.of(matchUserChoiceFirstRound, matchUserChoiceRematch)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
    }

    public String getTeam(List<String> teams) {
        boolean teamOk = false;
        teamUserChoice = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                teamUserChoice = dataReader.toLowerCase();
                teamUserChoice = dataReader.capitalizeFirstLetterEverySingleWord(teamUserChoice);
                for (String s : teams) {
                    if (teamUserChoice.equals(s)) {
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
        return teamUserChoice;
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
