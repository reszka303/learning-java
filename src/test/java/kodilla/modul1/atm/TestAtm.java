package kodilla.modul1.atm;

import org.junit.Test;

public class TestAtm {
    @Test
    public void displayingMethodOfATM() {
        //Given - Arrange
        ATMImpl atm = new ATMImpl();

        //When - Act
        System.out.println(atm.connectionToBank());
        System.out.println(atm.deposit());
        atm.withdrawal();
        ATM.finishingWorkATM();
    }
}
