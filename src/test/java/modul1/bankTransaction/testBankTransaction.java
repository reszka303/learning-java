package modul1.bankTransaction;

import kodilla.modul1.bankTransaction.ATM;
import org.junit.Test;

public class testBankTransaction {
    @Test
    public void testATM() {
        //Given - Arrange
        ATM atm = new ATM();

        //When - Act
        atm.run();
    }
}
