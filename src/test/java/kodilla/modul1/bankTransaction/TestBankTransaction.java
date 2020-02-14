package kodilla.modul1.bankTransaction;

import org.junit.Test;

public class TestBankTransaction {
    @Test
    public void testATM() {
        //Given - Arrange
        ATM atm = new ATM();

        //When - Act
        atm.run();
    }
}
