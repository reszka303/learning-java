package javaTasks.task1_Equals_and_HashCode;

import java.util.HashMap;
import java.util.Map;

public class PersonRunner {
    public static void main(String[] args) {
        Map<String,Person> persons = new HashMap<>();
        int sizeNoObject = persons.size();
        printLine("Wielkość mapy bez dodanych obiektów: " + sizeNoObject);
        persons = create();
        int sizeWithObjects = persons.size();
        printLine("Wielkość mapy po dodaniu obiektów: " + sizeWithObjects);
        printLine("");
        printLine("Osoby w mapie:");
        print(persons);
        printLine("");
        Person diCaprio = persons.get("DiCaprio");
        Person diCapri = persons.get("DiCapri");
        if (diCaprio.equals(diCapri)) {
            printLine("Obiekty DiCaprio i DiCapri są równe: " + true);
        } else {
            printLine("Obiekty DiCaprio i DiCapri są równe: " + false);
        }

        int hashDiCaprio = diCaprio.hashCode();
        printLine("hash dla DiCaprio " + hashDiCaprio);

        int hashDiCapri = diCapri.hashCode();
        printLine("hash dla DiCapri " + hashDiCapri);
    }

    private static Map<String, Person> create() {
        Map<String, Person> persons = new HashMap<>();
        persons.put("Peck", new Person("Gregory", "Peck", 45));
        persons.put("DiCaprio", new Person("Leonardo", "DiCaprio", 43));
        persons.put("Fonda", new Person("Henry", "Fonda", 75));
        persons.put("DiCapri", new Person("Leonardo", "DiCaprio", 43));
        return persons;
    }

    private static void print(Map<String, Person> map) {
        for (Map.Entry<String, Person> entry : map.entrySet()) {
            printLine(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
