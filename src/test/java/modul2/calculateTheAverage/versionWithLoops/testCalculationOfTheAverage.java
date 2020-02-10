package modul2.calculateTheAverage.versionWithLoops;

import kodilla.modul2.calculateTheAverage.versionWithLoops.Array;
import kodilla.modul2.calculateTheAverage.versionWithLoops.CalculationOfTheAverage;
import org.junit.Test;

public class testCalculationOfTheAverage {
    @Test
    public void calculationOfTheAverage() {
        //Given - Arrange
        Array array = new Array();

        //When - Act
        CalculationOfTheAverage calculationOfTheAverage = new CalculationOfTheAverage();
        calculationOfTheAverage.averageArray(array.getArray(), array.getAverage());
    }
}
