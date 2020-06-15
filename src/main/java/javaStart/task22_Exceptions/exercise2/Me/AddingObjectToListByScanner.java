package javaStart.task22_Exceptions.exercise2.Me;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingObjectToListByScanner {
    public static void main(String[] args) {

//        List<Participant> participants = new ArrayList<>();
//        participants.add(readAndCreateParticipant());
//        for (int i = 0; i < participants.size() ; i++) {
//            System.out.println(participants.get(i));
//        }
//        Participant participant = readAndCreateParticipant();
        Competition competition = readAndCreateCompetition();
        List<Participant> participants = addParticipant(competition);
        printParticipant(participants);

    }

    private static Competition readAndCreateCompetition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the competition:");
        String name = scanner.nextLine();
        System.out.println("Enter the maximum number of participants:");
        int numberParticipant = scanner.nextInt();
        System.out.println("Enter age restriction:");
        int ageLimit = scanner.nextInt();
        scanner.nextLine();

        return new Competition(name, numberParticipant, ageLimit);
    }

    private static Participant readAndCreateParticipant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add a new participant");
        System.out.println("Enter name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter surname");
        String surname = scanner.nextLine();
        System.out.println("Enter id");
        String id = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        return new Participant(firstName, surname, id, age);
    }

    private static List<Participant> addParticipant(Competition competition) {
        List<Participant> participants = new ArrayList<>();
        while (participants.size() < competition.getNumberParticipant()) {
            participants.add(readAndCreateParticipant());
        }
//        for (int i = 0; i < participants.size() ; i++) {
//            System.out.println(participants.get(i));
//        }
       return participants;
    }

    private static void printParticipant(List<Participant> participants) {
        for (Participant participant:
                participants) {
            System.out.println(participant);
        }
    }
}
