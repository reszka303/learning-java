package javaStart.task30_ComparableComparator.Me.exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PropertyDataReader {
    private static final String COMMA_DELIMITER = ";";

        static List<Property> readPropertiesFromTxt(String fileName) throws IOException {
            List<Property> properties = new ArrayList<>();
            try (var br = new BufferedReader(new FileReader(fileName))) {
                br.readLine();
                br.readLine();
                String line;

                while ((line = br.readLine()) != null) {
                    String[] delimeter = line.split(COMMA_DELIMITER);
                    Property property = createPropertyFromTxt(delimeter);
                    properties.add(property);
                }
            }
            return properties;
        }

    private static Property createPropertyFromTxt(String[] data) {
        String city = data[0];
        double price = Double.parseDouble(data[1]);
        double area = Double.parseDouble(data[2]);

        return new Property(city, price, area);
    }
}
