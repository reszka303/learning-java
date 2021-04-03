package javaStart.task39_Streams.exercise2.combined.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T3 {

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        List<String> teams = teams();
        teams.forEach(System.out::println);
        System.out.println("Podaj nazwę zespołu");
        String name = input.nextLine().toLowerCase();
        System.out.println(name);
        checkTeam(teams, name);

    }


    private static void checkTeam(List<String> teams, String name) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).equals(name)) {
                throw new TeamNotFoundException("There is no team with given name, try again");
            } else {
                System.out.println(name);
                break;
            }
        }
    }

    private static List<String> teams() {
        List<String> teams = new ArrayList<>();
        teams.add("poland");
        teams.add("germany");
        teams.add("italy");
        teams.add("spain");
        return teams;
    }

    private static class TeamNotFoundException extends RuntimeException {
        public TeamNotFoundException(String message) {
            System.err.println(message);
        }
    }
}

