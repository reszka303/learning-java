package javaStart.task25_FileOperations.JS.exercise2;

import java.io.FileNotFoundException;
import java.util.Scanner;

class ClientExplorer {
    public static void main(String[] args) {
        final String fileName = "clients.csv";
        try {
            Client[] clients = ClientDataReader.readFile(fileName);
            printMostValuableClient(clients);
            String country = readCountryFromUser();
            printClientsFromCountry(clients, country);
            printAvgValueForCountry(clients, country);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku o nazwie " + fileName);
        }
    }

    private static void printAvgValueForCountry(Client[] clients, String country) {
        double totalValue = 0;
        int clientsFromCountryCounter = 0;
        for (Client client : clients) {
            if (country.equals(client.getCountry())) {
                totalValue += client.getValue();
                clientsFromCountryCounter++;
            }
        }
        if (totalValue > 0) {
            double avgValue = totalValue / clientsFromCountryCounter;
            System.out.printf("Średnia wartość klienta z %s to %.2f", country, avgValue);
        }
    }

    private static void printClientsFromCountry(Client[] clients, String country) {
        System.out.println("Klienci z kraju " + country + ":");
        boolean atLeastOneClient = false;
        for (Client client : clients) {
            if (country.equals(client.getCountry())) {
                System.out.println(client);
                atLeastOneClient = true;
            }
        }
        if (!atLeastOneClient) {
            System.out.println("Brak klientów");
        }
    }

    private static String readCountryFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę kraju, z którego klienci Cię interesują:");
        return scanner.nextLine();
    }

    private static void printMostValuableClient(Client[] clients) {
        Client mostValuableClient = clients[0];
        for (Client client : clients) {
            if (client.getValue() > mostValuableClient.getValue()) {
                mostValuableClient = client;
            }
        }
        System.out.println("Najbardziej wartościowy klient to: " + mostValuableClient);
    }
}
