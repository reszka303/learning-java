package javaStart.task41_DatesAndTime.lesson;

import java.time.Duration;
import java.time.Instant;

public class TimeTestInstant {
    public static void main(String[] args) {
        //Aplikacja mierzy ile czasu zajmuje utworzenie obiektu t1 do utworzenia obiektu t2
        //Klasa Instant sprawdza ile czasu wykona się kod między dwoma punktami
        //np między dwoma metodami

        Instant t1 = Instant.now();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("time measure");
        }
        Instant t2 = Instant.now();
        Duration timeGap = Duration.between(t1, t2);
        System.out.println("Pętla wykonała sie w " + timeGap.getSeconds() + " sekundach");
    }
}
