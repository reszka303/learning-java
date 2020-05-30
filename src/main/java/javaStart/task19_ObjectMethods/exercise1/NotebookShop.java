package javaStart.task19_ObjectMethods.exercise1;

public class NotebookShop {
    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        dataStore.add(new Computer("ASUS", 12345));
        dataStore.add(new Computer("ASUS", 12345));
        dataStore.add(new Computer("APPLE", 5));
        dataStore.add(new Computer("APPLE", 6));
        dataStore.add(new Computer("HP", 8871927));

        Computer findComputer = new Computer("ASUS", 12345);

        System.out.println(dataStore.checkAvailability(findComputer));
        System.out.println(dataStore.getInfo());
    }
}
