package javaStart.task22_Exceptions.exercise2.Me;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class DataReader {
    private ConsolePrinter printer;
    private Scanner scanner = new Scanner(System.in);

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    Competition createCompetition() {
        printer.printLine("Enter the name of the competition:");
        String name = scanner.nextLine();
        printer.printLine("Enter the maximum number of participants:");
        int numberParticipant = readPositiveNumber();
        printer.printLine("Enter age restriction:");
        int ageLimit = readPositiveNumber();
        scanner.nextLine();

        return new Competition(name, numberParticipant, ageLimit);
    }

    Participant createParticipant() {
        printer.printLine("Add a new participant");
        printer.printLine("Enter name:");
        String firstName = scanner.nextLine();
        printer.printLine("Enter surname");
        String surname = scanner.nextLine();
        printer.printLine("Enter id");
        String id = scanner.nextLine();
        printer.printLine("Enter age: ");
        int age = readPositiveNumber();
        scanner.nextLine();

        return new Participant(firstName, surname, id, age);
    }

    void addParticipant(List<Participant> participants,
                        Participant participant, Competition competition) {
        if (participant.getAge() < competition.getAgeLimit())
            throw new AgeViolationException(competition.getAgeLimit());
        checkDuplicate(participants, participant);
        participants.add(participant);
    }

    private int readPositiveNumber() {
        int number = -1;
        while (number < 0) {
            try {
                number = scanner.nextInt();
                if (number < 0) {
                    System.err.println("The number must be positive");
                }
            } catch (InputMismatchException e) {
                System.err.println("You must enter an integer number, try again");
                scanner.nextLine();
            }
        }
        return number;
    }

    void checkDuplicate(List<Participant> participants, Participant participant) {
        for (int i = 0; i < participants.size(); i++)
            if (participants.get(i).getId().equals(participant.getId()))
            throw new DuplicateException(participant);
    }
}
