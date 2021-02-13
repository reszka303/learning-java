package javaStart.task41_DatesAndTime.lesson;

import java.time.LocalDate;

public class TimeTestLocalDate {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate firstJanuary2014 = LocalDate.of(2014, 1, 1);

        System.out.println("Dzień roku to: " + now.getDayOfYear());
        System.out.println("Dzień miesiąca to: " + now.getDayOfMonth());

        boolean check = now.isAfter(firstJanuary2014);
        System.out.println("Czy " + now + " jest po " + firstJanuary2014 + "?");
        System.out.println(check);
        System.out.println("Pobranie roku za pomocą metody getYear(): " + now.getYear());
    }
}
