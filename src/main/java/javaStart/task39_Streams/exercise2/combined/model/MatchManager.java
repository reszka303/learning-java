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
    private List<Match> matchFirstRoundUserChoice = new ArrayList<>();
    private List<Match> matchRematchesUserChoice = new ArrayList<>();
    private List<Match> matchAllMatchesUserChoice = new ArrayList<>();
    private List<Scoring> scoringFirstRoundUserChoice = new ArrayList<>();
    private List<Scoring> scoringRematchesUserChoice = new ArrayList<>();
    private List<Scoring> scoringAllMatchesUserChoice = new ArrayList<>();
    private String teamFirstRoundUserChoice;
    private String teamRematchesUserChoice;
    private String teamUserChoiceAllMatches;
    //LaLiga's fields
    private List<Match> matchFirstRoundLaLiga = new ArrayList<>();
    private List<Match> matchRematchesLaLiga = new ArrayList<>();
    private List<Match> matchAllMatchesLaLiga = new ArrayList<>();
    private List<Scoring> scoringFirstRoundLaLiga = new ArrayList<>();
    private List<Scoring> scoringRematchesLaLiga = new ArrayList<>();
    private List<Scoring> scoringAllMatchesLaLiga = new ArrayList<>();
    //PremierLeague's fields
    private List<Match> matchFirstRoundPremierLeague = new ArrayList<>();
    private List<Match> matchRematchesPremierLeague = new ArrayList<>();
    private List<Match> matchAllMatchesPremierLeague = new ArrayList<>();
    private List<Scoring> scoringFirstRoundPremierLeague = new ArrayList<>();
    private List<Scoring> scoringRematchesPremierLeague = new ArrayList<>();
    private List<Scoring> scoringAllMatchesPremierLeague = new ArrayList<>();

    public List<String> getTeamsUserChoice() {
        return teamsUserChoice;
    }

    public List<Match> getMatchFirstRoundUserChoice() {
        return matchFirstRoundUserChoice;
    }

    public List<Match> getMatchRematchesUserChoice() {
        return matchRematchesUserChoice;
    }

    public List<Match> getMatchAllMatchesUserChoice() {
        return matchAllMatchesUserChoice;
    }

    public List<Scoring> getScoringFirstRoundUserChoice() {
        return scoringFirstRoundUserChoice;
    }

    public List<Scoring> getScoringRematchesUserChoice() {
        return scoringRematchesUserChoice;
    }

    public List<Scoring> getScoringAllMatchesUserChoice() {
        return scoringAllMatchesUserChoice;
    }

    public String getTeamFirstRoundUserChoice() {
        return teamFirstRoundUserChoice;
    }

    public String getTeamRematchesUserChoice() {
        return teamRematchesUserChoice;
    }

    public String getTeamUserChoiceAllMatches() {
        return teamUserChoiceAllMatches;
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

    public List<Match> getMatchFirstRoundPremierLeague() {
        return matchFirstRoundPremierLeague;
    }

    public List<Match> getMatchRematchesPremierLeague() {
        return matchRematchesPremierLeague;
    }

    public List<Match> getMatchAllMatchesPremierLeague() {
        return matchAllMatchesPremierLeague;
    }

    public List<Scoring> getScoringFirstRoundPremierLeague() {
        return scoringFirstRoundPremierLeague;
    }

    public List<Scoring> getScoringRematchesPremierLeague() {
        return scoringRematchesPremierLeague;
    }

    public List<Scoring> getScoringAllMatchesPremierLeague() {
        return scoringAllMatchesPremierLeague;
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
                matchFirstRoundUserChoice.add(match);
            }
        }
        return matchFirstRoundUserChoice;
    }

    public List<Match> createRematchesUserChoice(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(j), teams.get(i),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchRematchesUserChoice.add(match);
            }
        }
        return matchRematchesUserChoice;
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

    public List<Match> createRematchesLaLiga(List<String> teams) {
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

    public List<Match> createFirstRoundPremierLeague(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchFirstRoundPremierLeague.add(match);
            }
        }
        return matchFirstRoundPremierLeague;
    }

    public List<Match> createRematchesPremierLeague(List<String> teams) {
        Random random = new Random();
        int upperbound = 5;
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(j), teams.get(i),
                        random.nextInt(upperbound), random.nextInt(upperbound));
                matchRematchesPremierLeague.add(match);
            }
        }
        return matchRematchesPremierLeague;
    }

    public List<Scoring> createScoringFirstRoundUserChoice(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringFirstRoundUserChoice.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringFirstRoundUserChoice.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringFirstRoundUserChoice.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringFirstRoundUserChoice.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringFirstRoundUserChoice.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringFirstRoundUserChoice.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringFirstRoundUserChoice;
    }

    public List<Scoring> createScoringRematchesUserChoice(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematchesUserChoice.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematchesUserChoice.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematchesUserChoice.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematchesUserChoice.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematchesUserChoice.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematchesUserChoice.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringRematchesUserChoice;
    }

    public List<Scoring> createScoringUserChoiceAllMatches(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringAllMatchesUserChoice.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringAllMatchesUserChoice.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringAllMatchesUserChoice.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringAllMatchesUserChoice.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringAllMatchesUserChoice.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringAllMatchesUserChoice.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringAllMatchesUserChoice;
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

    public List<Scoring> createScoringRematchesLaLiga(List<Match> matches, List<String> teams) {
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

    public List<Scoring> createScoringFirstRoundPremierLeague(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringFirstRoundPremierLeague.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringFirstRoundPremierLeague.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringFirstRoundPremierLeague.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringFirstRoundPremierLeague.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringFirstRoundPremierLeague.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringFirstRoundPremierLeague.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringFirstRoundPremierLeague;
    }

    public List<Scoring> createScoringRematchesPremierLeague(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematchesPremierLeague.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematchesPremierLeague.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematchesPremierLeague.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringRematchesPremierLeague.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringRematchesPremierLeague.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringRematchesPremierLeague.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringRematchesPremierLeague;
    }

    public List<Scoring> createScoringAllMatchesPremierLeague(List<Match> matches, List<String> teams) {
        for (String team : teams) {
            for (Match match : matches) {
                if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringAllMatchesPremierLeague.add(new Scoring(1, team, 3, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringAllMatchesPremierLeague.add(new Scoring(1, team, 1, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getHomeTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringAllMatchesPremierLeague.add(new Scoring(1, team, 0, match.getHomeTeamGoal(), match.getAwayTeamGoal(),
                            match.getHomeTeamGoal() - match.getAwayTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() > match.getAwayTeamGoal()) {
                    scoringAllMatchesPremierLeague.add(new Scoring(1, team, 0, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() == match.getAwayTeamGoal()) {
                    scoringAllMatchesPremierLeague.add(new Scoring(1, team, 1, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                } else if (team.equals(match.getAwayTeam()) && match.getHomeTeamGoal() < match.getAwayTeamGoal()) {
                    scoringAllMatchesPremierLeague.add(new Scoring(1, team, 3, match.getAwayTeamGoal(), match.getHomeTeamGoal(),
                            match.getAwayTeamGoal() - match.getHomeTeamGoal()));
                }
            }
        }
        return scoringAllMatchesPremierLeague;
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
            return matchAllMatchesUserChoice = Stream.of(matchFirstRoundUserChoice, matchRematchesUserChoice)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
    }

    public List<Match> joinFirstRoundAndRematchesLaLiga() {
        return matchAllMatchesLaLiga = Stream.of(matchFirstRoundLaLiga, matchRematchesLaLiga)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Match> joinFirstRoundAndRematchesPremierLeague() {
        return matchAllMatchesPremierLeague = Stream.of(matchFirstRoundPremierLeague, matchRematchesPremierLeague)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public String getTeamFirstRoundUserChoice(List<String> teams) {
        boolean teamOk = false;
        teamFirstRoundUserChoice = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its first round");
                teamFirstRoundUserChoice = dataReader.toLowerCase();
                teamFirstRoundUserChoice = dataReader.capitalizeFirstLetterEverySingleWord(teamFirstRoundUserChoice);
                for (String s : teams) {
                    if (teamFirstRoundUserChoice.equals(s)) {
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
        return teamFirstRoundUserChoice;
    }

    public String getTeamRematchesUserChoice(List<String> teams) {
        boolean teamOk = false;
        teamRematchesUserChoice = null;
        int counter = 0;
        while (!teamOk) {
            try {
                printer.printLine("Enter a name of a team to display its rematches");
                teamRematchesUserChoice = dataReader.toLowerCase();
                teamRematchesUserChoice = dataReader.capitalizeFirstLetterEverySingleWord(teamRematchesUserChoice);
                for (String s : teams) {
                    if (teamRematchesUserChoice.equals(s)) {
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
        return teamRematchesUserChoice;
    }

    public String getTeamAllMatchesUserChoice(List<String> teams) {
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
