package javaStart.task12_Looper.exercise2;

import java.util.Scanner;

public class HospitalMainMenu {
    void executeMainMenu() {
        logicOfMainMenu();
    }

    private void logicOfMainMenu() {
        final String exit = "0";
        final String add_Patient = "1";
        final String remove_Patient = "2";
        final String display_Patient = "3";
        Scanner input = new Scanner(System.in);
        String option = "-1";

        CreatingHospitalPatient creatingHospitalPatient =
                new CreatingHospitalPatient();

        while (option != exit) {
            displayMainMenu();
            option = input.nextLine();

            switch (option) {
                case add_Patient:
                    Patient patient1 = enterPatientInformation(input);
                    creatingHospitalPatient.addPatient(patient1);
                    break;
                case remove_Patient:
                    Patient patient2 = enterPatientInformation(input);
                    creatingHospitalPatient.removePatient(patient2);
                    break;
                case display_Patient:
                    creatingHospitalPatient.displayingPatients();
                    break;
                case exit:
                    System.out.println("Program has been closed");
                    System.exit(0);
                    break;
                default:
                    System.out.println("No such option found");
            }
        }
    }

    private Patient enterPatientInformation(Scanner input) {
        Patient patient = new Patient();
        System.out.println("First name:");
        patient.setFirstName(input.nextLine());
        System.out.println("Surname");
        patient.setSurname(input.nextLine());
        System.out.println("Id:");
        patient.setId(input.nextLine());
        return patient;
    }

    private void displayMainMenu() {
        System.out.println("Available options:");
        System.out.println("1 - Adding a patient");
        System.out.println("2 - Remove a patient");
        System.out.println("3 - Display a list of patients");
        System.out.println("0 - Exit program");
        System.out.println("Choose an option");
    }
}
