package javaStart.task22_Exceptions.exercise2.Me;

import java.util.List;

public class ConsolePrinter {
    public void printCompetition(Competition competition) {
        printLine(competition.toString());
    }

    public void printParticipants(List<Participant> participants) {
        for (Participant participant:
             participants) {
            System.out.println(participant);
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
