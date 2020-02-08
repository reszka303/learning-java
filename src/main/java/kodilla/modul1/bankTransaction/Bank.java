package kodilla.modul1.bankTransaction;

public abstract class Bank {
    abstract protected void informationOnTheAcceptanceOfAWithdrawalRequestByTheBank();

    abstract protected void checkingAccountStatus();

    protected void confirmationOfWithdrawalOptions() {
        System.out.println("You can withdraw cash from an ATM");
    }

    public void run() {
        this.informationOnTheAcceptanceOfAWithdrawalRequestByTheBank();
        this.checkingAccountStatus();
        this.confirmationOfWithdrawalOptions();
    }
}
