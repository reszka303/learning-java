package kodilla.bankTransaction;

public class ATM extends Bank {
    public void cardInsertionRequest() {
        System.out.println("Please insert your debit card");
    }

    public void pinEntryRequest() {
        System.out.println("Please insert your PIN");
    }

    public void requestToEnterPaymentAmount() {
        System.out.println("Please enter the amount to withdrawal");
    }

    protected void informationOnTheAcceptanceOfAWithdrawalRequestByTheBank() {
        System.out.println("The bank accepted the cash withdrawal request");
    }

    protected void checkingAccountStatus() {
        System.out.println("Checking bank balance is in progress");
    }

    public void withdrawingCash() {
        System.out.println("Cash withdrawal in progress");
    }

    public void thankYouForUsingTheBanksServices() {
        System.out.println("Thank you for using the Bank's services");
    }

    @Override
    public void run() {
        this.cardInsertionRequest();
        this.pinEntryRequest();
        this.requestToEnterPaymentAmount();
        this.informationOnTheAcceptanceOfAWithdrawalRequestByTheBank();
        this.checkingAccountStatus();
        this.confirmationOfWithdrawalOptions();
        this.withdrawingCash();
        this.thankYouForUsingTheBanksServices();
    }
}
