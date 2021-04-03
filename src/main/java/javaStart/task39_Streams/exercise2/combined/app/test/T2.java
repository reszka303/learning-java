package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T2 {
    public static void main(String[] args) {
        List<String> teams = teams();
        List<Result> results = createResults();
        Map<String, Integer> map = getPoints(results);
        System.out.println(map);

        int sumPoints = 0;
        int sumGoalsFor = 0;
        int sumGoalsAgainst = 0;
        int sumGoalsDifference = 0;
        int counter = 0;

//        String teamName = "";
//        for (int i = 0; i < teams.size(); i++) {
//                if (counter == teams.indexOf(teams.get(i))) {
//                    teamName = teams.get(i);
//                }
//            counter++;
//        }
//
//        for (int j = 0; j < results.size(); j++) {
//            if (teamName.equals(results.get(j).getName())) {
//                sumPoints += results.get(j).getPoints();
//                sumGoalsFor += results.get(j).getGoalsFor();
//                sumGoalsAgainst += results.get(j).getGoalsAgainst();
//                sumGoalsDifference += results.get(j).getGoalsDifference();
//                resultsAfterSum.add(new Result(results.get(j).getName(), sumPoints, sumGoalsFor, sumGoalsAgainst, sumGoalsDifference));
//            }
//        }

    }

    private static Map<String, Integer> getPoints(List<Result> resultList) {
        return resultList.stream()
                .collect(Collectors.groupingBy(Result::getName, Collectors.summingInt(Result::getPoints)));
    }

    private static int sumPoints(List<Result> results) {
        return results.stream()
                .mapToInt(Result::getPoints)
                .sum();
    }

    private static int sumGoalsForResult (List<Result> results) {
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

    private static List<String> teams() {
        List<String> teams = new ArrayList<>();
        teams.add("Poland");
        teams.add("Germany");
        teams.add("Italy");
        teams.add("Spain");
        return teams;
    }

    private static List<Result> createResults() {
        List<Result> results = new ArrayList<>();
        results.add(new Result("poland",1, 0,0,0));
        results.add(new Result("poland",0,   3,   4,   -1));
        results.add(new Result("poland",3,   1,   0,   1));
        results.add(new Result("germany",1,   0,   0,   0));
        results.add(new Result("germany",1,   2,   2,   0));
        results.add(new Result("germany",0,   1,   3,   -2));
        results.add(new Result("italy",3,   4,   3,   1 ));
        results.add(new Result("italy",1,   2,   2,   0 ));
        results.add(new Result("italy",3,   3,   1,   2));
        results.add(new Result("spain",0,   0,   1,   -1));
        results.add(new Result("spain",3,   3,   1,   2));
        results.add(new Result("spain",0,   1,   3,   -2));
        return results;
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
}
