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
        Competition competition = dataReader.createCompetition();
        return competition;
    }

    private List<Participant> addParticipant(Competition competition) {
        List<Participant> participants = new ArrayList<>();
        while (participants.size() < competition.getNumberParticipant()) {
            Participant participant = dataReader.createParticipant();
            try {
                dataReader.addParticipant(participants, participant,
                        competition);
            } catch (AgeViolationException e) {
                System.err.println("No participant added, minimum age:" +
                        e.getAgeRequired());
            } catch (DuplicateException e) {
                System.err.println("The participant with the identifier" +
                        " has already been added to this competition " +
                        e.getParticipant());
            }
        }
        return participants;
    }
}
