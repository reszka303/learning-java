package javaStart.task22_Exceptions.exercise2.Me;

import java.util.ArrayList;
import java.util.List;

public class CompetitionControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);

    void run() {
        Competition competition = addCompetition();
        List<Participant> participants = addParticipant(competition);
        printer.printCompetition(competition);
        printer.printParticipants(participants);
    }

    private Competition addCompetition() {
        Competition competition = dataReader.readAndCreateCompetition();
        return competition;
    }

    private List<Participant> addParticipant(Competition competition) {
        List<Participant> participants = new ArrayList<>();
        while (participants.size() < competition.getNumberParticipant()) {
            participants.add(dataReader.readAndCreateParticipant());
        }
        return participants;
    }
}
