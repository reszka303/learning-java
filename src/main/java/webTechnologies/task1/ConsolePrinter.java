package webTechnologies.task1;

public class ConsolePrinter {
    String printStats(int days, int hours, int minutes, int seconds) {
        var sb = new StringBuilder();
        sb.append(days).append(" days ");
        sb.append("have passed since the beginning of the year. ");
        sb.append("It is ").append(hours).append(" hours, ");
        sb.append(minutes).append(" minutes, ");
        sb.append(seconds).append(" seconds. ");
        return sb.toString();
    }

    void printLine(String text) {
        System.out.println(text);
    }

    void printLineError(String text) {
        System.err.println(text);
    }
}
