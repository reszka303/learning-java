package javaStart.task34_Queue.Test;

public class TestEnum {
    public static void main(String[] args) {
        int counter = 0;
        for (Priority priority: Priority.values()) {
            counter++;
            if (Priority.values().length == counter) {
                System.out.print(priority);
            } else {
                System.out.print(priority + ", ");
            }
        }
    }

    private enum Priority {
        HIGH, MODERATE, LOW
    }
}
