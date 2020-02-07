package kodilla.modul1.braveKnight;

import java.util.Random;

public interface Quest {
    void beginningOfProcess();

    void process();

    static String finishingOfProcess() {
        Random random = new Random();
        boolean isAccomplished = random.nextBoolean();
        if(isAccomplished) {
            return "Mission accomplished";
        } else
            return "Mission failure";
    }

}
