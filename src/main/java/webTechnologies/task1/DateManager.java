package webTechnologies.task1;

public class DateManager {
    private static final int minutes = 24 * 60;
    private static final int seconds = 60 * 60 * 24;

    int getDays(int number) {
        return number;
    }

    int getHours(int number) {
        return number * 24;
    }

    int getMinutes(int number) {
        return minutes * number;

    }

    int getSeconds(int number) {
        return seconds * number;
    }
}
