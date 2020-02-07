package bankTransaction;

import kodilla.bankTransaction.ATM;
import org.junit.Test;

public class testBankTransaction {
    @Test
    public void testATM() {
        ATM atm = new ATM();
        atm.run();
    }
}
