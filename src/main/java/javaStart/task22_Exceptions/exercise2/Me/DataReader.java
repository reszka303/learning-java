package javaStart.task22_Exceptions.exercise2.Me;

import java.util.Scanner;

class DataReader {
    ConsolePrinter printer;
    Scanner scanner = new Scanner(System.in);

    public DataReader() {
    }

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    Competition readAndCreateCompetition() {
        printer.printLine("Enter the name of the competition:");
        String name = scanner.nextLine();
        printer.printLine("Enter the maximum number of participants:");
        int numberParticipant = scanner.nextInt();
        printer.printLine("Enter age restriction:");
        int ageLimit = scanner.nextInt();
        scanner.nextLine();

        return new Competition(name, numberParticipant, ageLimit);

    }

    Participant readAndCreateParticipant() {
        printer.printLine("Add a new participant");
        printer.printLine("Enter name:");
        String firstName = scanner.nextLine();
        printer.printLine("Enter surname");
        String surname = scanner.nextLine();
        printer.printLine("Enter id");
        String id = scanner.nextLine();
        printer.printLine("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        return new Participant(firstName, surname, id, age);
    }
}
