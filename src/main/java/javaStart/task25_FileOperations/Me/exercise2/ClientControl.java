package javaStart.task25_FileOperations.Me.exercise2;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.Scanner;

public class ClientControl {
    private final String fileName = "clients.csv";

    void run() {
        try {
            List clients = readFile();
            printClients(clients);
            ConsolePrinter.printLine("");
            mostValuableClient(clients);
            String country = readCountry();
            getCountry(clients, country);
            double average = getValueAverage(clients, country);
            ConsolePrinter.printLine("");
            printAverage(average, country);
        } catch (DataImportException e) {
            e.getMessage();
        }
    }

    private List<Client> readFile() {
        try {
            List<Client> clients = ClientDataReader.readClientsFromCSV(fileName);
            return clients;
        } catch (FileNotFoundException e) {
            throw new DataImportException("No file " + fileName);
        } catch (IOException e) {
            throw new DataImportException("Error file read " + fileName);
        }
    }

    private void printClients(List<Client> clients) {
        for (Client client:
                clients) {
            System.out.println(client.toString());
        }
    }

    private void mostValuableClient(List<Client> clients) {
       Client mostValuableClient = clients.get(0);

        for (Client client:
             clients) {
            if (client.getValue() > mostValuableClient.getValue()) {
                mostValuableClient = client;
            }
        }

        ConsolePrinter.printLine("The most valuable client is: " +
                mostValuableClient);
    }

    private void getCountry(List<Client> clients, String country) {
        ConsolePrinter.printLine("Clients from " + country + ": ");
        boolean atLeastOneCountry = false;
        for (Client client:
             clients) {
            if (country.equals(client.getCountry())) {
                ConsolePrinter.printLine(client.toString());
                atLeastOneCountry = true;
            }
        }
        if (!atLeastOneCountry) {
            ConsolePrinter.printLine("No clients");
        }
    }

    private String readCountry() {
        Scanner scanner = new Scanner(System.in);
        ConsolePrinter.printLine("Give client's country: ");
        return scanner.nextLine();
    }

    private double getValueAverage(List<Client> clients, String country) {
        double sumSelectedCountries = 0;
        double averageSelectedCountries = 0;
        int counterCountries = 0;

        for (Client client:
             clients) {
            if (country.equals(client.getCountry())) {
                sumSelectedCountries += client.getValue();
                counterCountries++;
            }
            if (counterCountries != 0) {
                averageSelectedCountries =
                        sumSelectedCountries /counterCountries;
            }
        }
        return averageSelectedCountries;
    }

    private void printAverage(double averageSelectedCountries, String country) {
        if (averageSelectedCountries != 0) {
            ConsolePrinter.printLine("Clients' average from " +
                    country + " is: " + averageSelectedCountries);
        }
    }
}
