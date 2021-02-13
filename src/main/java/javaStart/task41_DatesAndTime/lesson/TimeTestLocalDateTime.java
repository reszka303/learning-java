package javaStart.task41_DatesAndTime.lesson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeTestLocalDateTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Tworzę wydarzenie");
        System.out.println("Podaj datę w formacie yyyy-MM-dd");
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateInput = input.nextLine();

        LocalDate createDate = LocalDate.parse(dateInput, datePattern);
        System.out.println("Wydarzenie utworzone na dzień: " + createDate);
    }
}
