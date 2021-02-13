package javaStart.task41_DatesAndTime.lesson;

import java.time.LocalTime;

public class TimeTestLocalTime {
    public static void main(String[] args) throws InterruptedException {
        //Aplikacja zwiększa nam o sekundę odczyt czasu

        LocalTime now = LocalTime.now();
        for (int i = 0; i < 5; i++) {
            System.out.println("Formatowanie czasu szczegółowe " + now);
            System.out.println("Formatowanie czasu według metod get klasy LocalTime: "
                    + now.getHour() + "-" + now.getMinute() + "-" + now.getSecond());
            now = now.plusSeconds(1);
            Thread.sleep(1000);
        }
    }
}
