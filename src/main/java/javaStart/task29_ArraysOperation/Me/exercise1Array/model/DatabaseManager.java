package javaStart.task29_ArraysOperation.Me.exercise1Array.model;

public class DatabaseManager {
    private PersonDatabase personDatabase = new PersonDatabase();
    private CarDatabase carDatabase = new CarDatabase();

    public PersonDatabase getPersonDatabase() {
        return personDatabase;
    }

    public CarDatabase getCarDatabase() {
        return carDatabase;
    }
}
