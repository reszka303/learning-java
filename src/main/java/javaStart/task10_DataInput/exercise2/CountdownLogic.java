package javaStart.task10_DataInput.exercise2;

public class CountdownLogic implements java.lang.Runnable {
    @Override
    public void run() {
        this.run();
    }
    public void runTimer() {
        int i = 10;
        while (i > 0) {
            System.out.println(i);
            try {
                i--;
                Thread.sleep(1000L);
            } catch (InterruptedException e) {

            }
        }
    }
}
