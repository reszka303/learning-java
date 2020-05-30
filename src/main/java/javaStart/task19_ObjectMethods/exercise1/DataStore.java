package javaStart.task19_ObjectMethods.exercise1;

public class DataStore {
    private static final int MAX_NOTEBOOK = 100;
    private Computer[] computers = new Computer[MAX_NOTEBOOK];
    private int computersNumber;

    Computer[] add(Computer computer) {
        if (computersNumber < MAX_NOTEBOOK) {
            computers[computersNumber] = computer;
            computersNumber++;
        }
        return computers;
    }

    String getInfo() {
        String info = "";
        if (computersNumber == 0) {
            System.out.println("There is no notebook");
        } else {
            for (int i = 0; i < computersNumber; i++) {
                info = info + computers[i].toString();
            }
        }
        return info;
    }

    int checkAvailability(Computer computer) {
        if (computer == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < computersNumber; i++) {
            if (computer.equals(computers[i])) {
                count++;
            }
        }
        return count;
    }
}
