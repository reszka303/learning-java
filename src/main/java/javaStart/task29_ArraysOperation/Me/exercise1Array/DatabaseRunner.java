package javaStart.task29_ArraysOperation.Me.exercise1Array;

public class DatabaseRunner {
    public static void main(String[] args) {
        PersonDatabase database = new PersonDatabase();

        Person gregoryPeck = new Person(
                "Gregory", "Peck", "10");
        Person leonardoDiCaprio = new Person(
                "Leonardo", "DiCaprio", "20");

        database.add(gregoryPeck);
        database.add(leonardoDiCaprio);

        printLine("" + database);
        printLine("");

        database.remove(leonardoDiCaprio);
        printLine("" + database);
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
