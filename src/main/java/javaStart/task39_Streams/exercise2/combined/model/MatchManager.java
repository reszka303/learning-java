package javaStart.task39_Streams.exercise2.combined.model;

import javaStart.task39_Streams.exercise2.combined.exception.TeamDuplicateException;
import javaStart.task39_Streams.exercise2.combined.io.DataReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatchManager {
    private DataReader dataReader = new DataReader();
    private List<String> teams = new ArrayList<>();
    private List<Match> matches = new ArrayList<>();
    private List<Result> results = new ArrayList<>();

    public List<String> getTeams() {
        return teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> addTeams(int numberTeam) {
        String team;
            while (teams.size() < numberTeam) {
                try {
                    team = dataReader.createTeam();
                    checkDuplicate(team);
                    teams.add(team);
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
}
