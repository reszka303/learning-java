package javaStart.task30_ComparableComparator.Me.exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyDataReader {
        static List<Property> readPropertiesFromTxt(String fileName) throws IOException {
            List<Property> properties = new ArrayList<>();
            try (var bufferedReader = new BufferedReader(new FileReader(fileName))){
                bufferedReader.readLine();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    List<String> delimeter = Arrays.asList(line.split(";"));
//                    String[] delimeter = line.split(";");
                    Property property = createPropertyFromTxt(delimeter);
//                    Property property = createPropertyFromTxt(delimeter);
                    properties.add(property);
                }
            }
            return properties;
        }

//    private static Property createPropertyFromTxt(String[] data) {
//        String city = data[0];
//        double price = Double.parseDouble(data[1]);
//        double area = Double.parseDouble(data[2]);
//
//        return new Property(city, price, area);
//    }

    private static Property createPropertyFromTxt(List<String> data) {
        String city = data.get(0);
        double price = Double.parseDouble(data.get(1));
        double area = Double.parseDouble(data.get(2));

        return new Property(city, price, area);
    }
}
