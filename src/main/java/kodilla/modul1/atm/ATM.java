package kodilla.modul1.atm;

public interface ATM {
    default String connectionToBank() {
        return "The connection with the bank has finished successfully";
    }

    String deposit();

    void withdrawal();

    static void finishingWorkATM() {
        System.out.println("The work of ATM has finished successfully");
    }
}
