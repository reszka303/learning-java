package javaStart.task41_DatesAndTime.exercise1;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Timer {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Instant startTime = Instant.now();
            printLine("Press Enter to start the measurement");
            input.nextLine();
            printLine("Press Enter to stop the measurement");
            input.nextLine();
            Instant stopTime = Instant.now();
            Duration totalTime = Duration.between(startTime, stopTime);
            printLine("Duration is: " + totalTime.getSeconds());
        }
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
