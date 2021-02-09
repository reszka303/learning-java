package javaStart.task39_Streams.exercise2.extended;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Poland");
        teams.add("Italy");
        teams.add("Germany");
        teams.add("Spain");

        List<Match> matches = scores(teams);
        matches.forEach(System.out::println);

        int sum = sumGoals(matches);
        System.out.println("Poland scored: " + sum + " goals");

        long sumStream = sumGoalsStream(matches);
        System.out.println("Poland scored Stream: " + sumStream + " goals");
    }

    private static List<Match> scores(List<String> list) {
        Random random = new Random();
        int upperbound = 5;
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size() ; j++) {
                Match match = new Match(list.get(i), list.get(j), random.nextInt(upperbound),
                        random.nextInt(upperbound));
                matches.add(match);
            }
        }
        return matches;
    }

    private static long sumGoalsStream(List<Match> list) {
        return list.stream()
                .filter(test::indicateTeam)
                .mapToInt(Match::goalsSum)
                .sum();
    }

    private static int sumGoals(List<Match> list) {
        int sum = 0;
        for (Match match : list) {
            if (match.getHomeTeam().equals("Poland") || match.getAwayTeam().equals("Poland")) {

            }
        }
        return sum;
    }

    private static boolean indicateTeam(Match match) {
        return match.getHomeTeam().equals("Poland") || match.getAwayTeam().equals("Poland");
    }
}
