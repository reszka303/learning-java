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
    //UserChoice's fields
    private List<String> teamsUserChoice = new ArrayList<>();
    private List<Match> matchUserChoiceFirstRound = new ArrayList<>();
    private List<Match> matchUserChoiceRematch = new ArrayList<>();
    private List<Match> matchUserChoiceAllMatches = new ArrayList<>();
    private List<Scoring> scoringUserChoiceFirstRound = new ArrayList<>();
    private List<Scoring> scoringUserChoiceRematch = new ArrayList<>();
    private List<Scoring> scoringUserChoiceAllMatches = new ArrayList<>();
    private String teamUserChoiceFirstRound;
    private String teamUserChoiceRematches;
    private String teamUserChoiceAllMatches;
    //LaLiga's fields
    private List<Match> matchFirstRoundLaLiga = new ArrayList<>();
    private List<Match> matchRematchesLaLiga = new ArrayList<>();
    private List<Match> matchAllMatchesLaLiga = new ArrayList<>();
    private List<Scoring> scoringFirstRoundLaLiga = new ArrayList<>();
    private List<Scoring> scoringRematchesLaLiga = new ArrayList<>();
    private List<Scoring> scoringAllMatchesLaLiga = new ArrayList<>();
    private String teamFirstRoundLaLiga;
    private String teamRematchesLaLiga;
    private String teamAllMatchesLaLiga;
    //PremierLeague's fields
    private List<Match> matchFirstRoundPremierLeague = new ArrayList<>();
    private List<Match> matchRematchesPremierLeague = new ArrayList<>();
    private List<Match> matchAllMatchesPremierLeague = new ArrayList<>();
    private List<Scoring> scoringFirstRoundPremierLeague = new ArrayList<>();
    private List<Scoring> scoringRematchesPremierLeague = new ArrayList<>();
    private List<Scoring> scoringAllMatchesPremierLeague = new ArrayList<>();
    private String teamFirstRoundPremierLeague;
    private String teamRematchesPremierLeague;
    private String teamAllMatchesPremierLeague;


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

    public List<Match> getMatchFirstRoundLaLiga() {
        return matchFirstRoundLaLiga;
    }

    public List<Match> getMatchRematchesLaLiga() {
        return matchRematchesLaLiga;
    }

    public List<Match> getMatchAllMatchesLaLiga() {
        return matchAllMatchesLaLiga;
    }

    public List<Scoring> getScoringFirstRoundLaLiga() {
        return scoringFirstRoundLaLiga;
    }

    public List<Scoring> getScoringRematchesLaLiga() {
        return scoringRematchesLaLiga;
    }

    public List<Scoring> getScoringAllMatchesLaLiga() {
        return scoringAllMatchesLaLiga;
    }

    public String getTeamFirstRoundLaLiga() {
        return teamFirstRoundLaLiga;
    }

    public String getTeamRematchesLaLiga() {
        return teamRematchesLaLiga;
    }

    public String getTeamAllMatchesLaLiga() {
        return teamAllMatchesLaLiga;
    }

    //
//    public List<Match> getMatchFirstRoundPremierLeague() {
//        return matchFirstRoundPremierLeague;
//    }
//
//    public List<Match> getMatchRematchPremierLeague() {
//        return matchRematchPremierLeague;
//    }

    public String getTeamUserChoiceFirstRound() {
        return teamUserChoiceFirstRound;
    }

    public String getTeamUserChoiceRematches() {
        return teamUserChoiceRematches;
    }

    public String getTeamUserChoiceAllMatches() {
        return teamUserChoiceAllMatches;
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

    public List<Match> createFirstRoundLaLiga(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchFirstRoundLaLiga.add(match);
            }
        }
        return matchFirstRoundLaLiga;
    }

    public List<Match> createRematchLaLiga(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(j), teams.get(i),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchRematchesLaLiga.add(match);
            }
        }
        return matchRematchesLaLiga;
    }

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

    public List<Scoring> createScoringFirstRoundLaLiga(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringFirstRoundLaLiga.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringFirstRoundLaLiga.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringFirstRoundLaLiga.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringFirstRoundLaLiga.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringFirstRoundLaLiga.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringFirstRoundLaLiga.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringFirstRoundLaLiga;
    }

    public List<Scoring> createScoringRematchLaLiga(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematchesLaLiga.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematchesLaLiga.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematchesLaLiga.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematchesLaLiga.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematchesLaLiga.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematchesLaLiga.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringRematchesLaLiga;
    }

    public List<Scoring> createScoringAllMatchesLaLiga(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringAllMatchesLaLiga.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringAllMatchesLaLiga.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringAllMatchesLaLiga.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringAllMatchesLaLiga.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringAllMatchesLaLiga.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringAllMatchesLaLiga.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringAllMatchesLaLiga;
    }

    public Map<Scoring, List<Scoring>> groupByName(List<Scoring> scoring) {
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

    public List<Match> joinFirstRoundAndRematchesUserChoice() {
            return matchUserChoiceAllMatches = Stream.of(matchUserChoiceFirstRound, matchUserChoiceRematch)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
    }

    public List<Match> joinFirstRoundAndRematchesLaLiga() {
        return matchAllMatchesLaLiga = Stream.of(matchFirstRoundLaLiga, matchRematchesLaLiga)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public String getTeamFirstRound(List<String> teams) {
        boolean teamOk = false;
        teamUserChoiceFirstRound = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                teamUserChoiceFirstRound = dataReader.toLowerCase();
                teamUserChoiceFirstRound = dataReader.capitalizeFirstLetterEverySingleWord(teamUserChoiceFirstRound);
                for (String s : teams) {
                    if (teamUserChoiceFirstRound.equals(s)) {
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
        return teamUserChoiceFirstRound;
    }

    public String getTeamRematches(List<String> teams) {
        boolean teamOk = false;
        teamUserChoiceRematches = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                teamUserChoiceRematches = dataReader.toLowerCase();
                teamUserChoiceRematches = dataReader.capitalizeFirstLetterEverySingleWord(teamUserChoiceRematches);
                for (String s : teams) {
                    if (teamUserChoiceRematches.equals(s)) {
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
        return teamUserChoiceRematches;
    }

    public String getTeamAllMatches(List<String> teams) {
        boolean teamOk = false;
        teamUserChoiceAllMatches = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                teamUserChoiceAllMatches = dataReader.toLowerCase();
                teamUserChoiceAllMatches = dataReader.capitalizeFirstLetterEverySingleWord(teamUserChoiceAllMatches);
                for (String s : teams) {
                    if (teamUserChoiceAllMatches.equals(s)) {
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
        return teamUserChoiceAllMatches;
    }

    public String getTeamFirstRoundLaLiga(List<String> teams) {
        boolean teamOk = false;
        teamFirstRoundLaLiga = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                teamFirstRoundLaLiga = dataReader.toLowerCase();
                teamFirstRoundLaLiga = dataReader.capitalizeFirstLetterEverySingleWord(teamFirstRoundLaLiga);
                for (String s : teams) {
                    if (teamFirstRoundLaLiga.equals(s)) {
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
        return teamFirstRoundLaLiga;
    }

    public String getTeamRematchesLaLiga(List<String> teams) {
        boolean teamOk = false;
        teamRematchesLaLiga = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                teamRematchesLaLiga = dataReader.toLowerCase();
                teamRematchesLaLiga = dataReader.capitalizeFirstLetterEverySingleWord(teamRematchesLaLiga);
                for (String s : teams) {
                    if (teamRematchesLaLiga.equals(s)) {
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
        return teamRematchesLaLiga;
    }

    public String getTeamAllMatchesLaLiga(List<String> teams) {
        boolean teamOk = false;
        teamAllMatchesLaLiga = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its all matches");
                teamAllMatchesLaLiga = dataReader.toLowerCase();
                teamAllMatchesLaLiga = dataReader.capitalizeFirstLetterEverySingleWord(teamAllMatchesLaLiga);
                for (String s : teams) {
                    if (teamAllMatchesLaLiga.equals(s)) {
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
        return teamAllMatchesLaLiga;
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
