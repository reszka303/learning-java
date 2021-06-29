package webTechnologies.task1;

public class DateManager {
    private static final int minutes = 24 * 60;
    private static final int seconds = 60 * 60 * 24;

    int getDays(int days) {
        return days;
    }

    int getHours(int days) {
        return days * 24;
    }

    int getMinutes(int days) {
        return minutes * days;

    }

    int getSeconds(int days) {
        return seconds * days;
    }
}
