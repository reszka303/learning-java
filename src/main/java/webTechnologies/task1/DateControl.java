package webTechnologies.task1;

public class DateControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader();
    private DateManager dateManager = new DateManager();

    void run() {
        int day = getDays();
        int days = getDays(day);
        int hours = getHours(day);
        int minutes = getMinutes(day);
        int seconds = getSeconds(day);
        printer.printLine(printer.printStats(days, hours, minutes, seconds));
    }

    private int getDays() {
        return dataReader.getDay();
    }

    private int getDays(int number) {
       return dateManager.getDays(number);
    }

    private int getHours(int number) {
        return dateManager.getHours(number);
    }

    private int getMinutes(int number) {
        return dateManager.getMinutes(number);
    }

    private int getSeconds(int number) {
        return dateManager.getSeconds(number);
    }
}
