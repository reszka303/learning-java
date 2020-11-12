package javaStart.task29_ArraysOperation.JS.exercise1;

public class DatabaseTest {
    public static void main(String[] args) {
        PersonDatabase database = new PersonDatabase();
        database.add(new Person("Jan", "Kowalski", "12345"));
        database.add(new Person("Ania", "Zalewska", "234567"));
        database.add(new Person("Karol", "Piotrowski", "345678"));
        database.add(new Person("Patryk", "Bielecki", "45678"));
        Person person = database.get(1);
        System.out.println(person);
        System.out.println(database);
        database.remove(new Person("Patryk", "Bielecki", "45678"));
        System.out.println(database);
    }
}
