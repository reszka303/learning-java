package javaStart.task25_FileOperations.Me.exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientDataReader {
    static List<Client> readClientsFromCSV(String fileName) throws IOException {
        List<Client> clients = new ArrayList<>();
        try (
                var bufferedReader = new BufferedReader(new FileReader(fileName));
                ) {
            bufferedReader.readLine();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] delimiter = line.split(",");
                Client client = createClientFromCSV(delimiter);
                clients.add(client);
            }
        }
        return clients;
    }

    private static Client createClientFromCSV(String[] data) {
        int id = Integer.parseInt(data[0]);
        String firstName = data[1];
        String surname = data[2];
        String country = data[3];
        double value = Double.parseDouble(data[4]);

        return new Client(id, firstName, surname, country, value);
    }
}
