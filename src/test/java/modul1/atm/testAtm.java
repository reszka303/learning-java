package modul1.atm;

import kodilla.modul1.atm.ATM;
import kodilla.modul1.atm.ATMImpl;
import org.junit.Test;

public class testAtm {
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
