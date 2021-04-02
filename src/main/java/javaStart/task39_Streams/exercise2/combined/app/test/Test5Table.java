package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test5Table {
    public static void main(String[] args) {
        List<Result> results = create();
//        results.forEach(System.out::println);
//        printLine("Przed zmianą pola place");
//        for (Result result : results) {
//            printLine(result.toString());
//        }

//        results.get(2).setPlace(results.get(2).getPlace() + 1);
//        results.forEach(System.out::println);

//        int counter = 0;
//        for (int i = 0; i < results.size(); i++) {
//            if (i == counter) {
//                printLine("Counter: " + counter);
//                printLine("i : " + i);
//                printLine("Place: " + results.get(i).getPlace());
//                results.get(i).setPlace(results.get(i).getPlace() + counter);
//            }
//            counter++;
//            printLine("Counter poza pętlą: " + counter);
//        }
//
//        printLine("Po zmianie pola place");
//        results.forEach(System.out::println);

        results.stream()
                .peek(result ->  {
                    int counterStream = 0;
                    for (int i = 0; i < results.size(); i++) {
                        if (i == counterStream) {
                            results.get(i).setPlace(results.get(i).getPlace() + 1);
                        }
                        counterStream++;
                    }
        })
                .forEach(System.out::println);


    }

    private static List<Result> create() {
        List<Result> results = new ArrayList<>();
        results.add(new Result(0, "Poland", 9,   10,  2,   8));
        results.add(new Result(0, "Germany", 4,   6,   5,   1));
        results.add(new Result(0, "Spain", 3,   4,   7,   -3));
        results.add(new Result(0, "France", 1,   4,   10,  -6 ));
        return results;
    }

    private static class Result {
        private int place;
        private String name;
        private int points;
        private int goalsFor;
        private int goalsAgainst;
        private int goalsDifference;

        public Result(int place, String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
            this.place = place;
            this.name = name;
            this.points = points;
            this.goalsFor = goalsFor;
            this.goalsAgainst = goalsAgainst;
            this.goalsDifference = goalsDifference;
        }

        public int getPlace() {
            return place;
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

        public void setPlace(int place) {
            this.place = place;
        }

        //        @Override
//        public String toString() {
//            return place + " " + name + " " + points + " " + goalsFor + " " + goalsAgainst + " " + goalsDifference;
//        }

        public String toString() {
            return String.format("%-5s %-10s %-3s %-3s %-3s %-3s",place + ".", name, points, goalsFor, goalsAgainst, goalsDifference);
        }
    }

    private static class Table {
        private int place;
        private String name;
        private int points;
        private int goalsFor;
        private int goalsAgainst;
        private int goalsDifference;

        public Table(int place, String name, int points, int goalsFor, int goalsAgainst, int goalsDifference) {
            this.place = place;
            this.name = name;
            this.points = points;
            this.goalsFor = goalsFor;
            this.goalsAgainst = goalsAgainst;
            this.goalsDifference = goalsDifference;
        }

        public String toString() {
            return String.format("%-5s %-10s %-3s %-3s %-3s %-3s", place + ".", name, points, goalsFor, goalsAgainst, goalsDifference);
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
