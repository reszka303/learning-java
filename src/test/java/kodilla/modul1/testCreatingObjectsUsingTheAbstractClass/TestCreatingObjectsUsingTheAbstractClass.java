package kodilla.modul1.testCreatingObjectsUsingTheAbstractClass;

import kodilla.modul1.creatingObjectsUsingTheAbstractClass.FullTimeEmployee;
import kodilla.modul1.creatingObjectsUsingTheAbstractClass.PieceworkEmployee;
import org.junit.Test;

public class TestCreatingObjectsUsingTheAbstractClass {
    @Test
    public void testPieceworkEmployee () {
        //Given - Arrange
        PieceworkEmployee jakobBaird = new PieceworkEmployee("Jakob", "Baird",
                10, 200);

        //When - Act
        jakobBaird.wayOfCalculatingSalary();
    }

    @Test
    public void testFullTimeEmployeeBonus() {
        //Given - Arrange
        FullTimeEmployee seanJoseph = new FullTimeEmployee("Sean", "Joseph",
                2000, 20, true);

        //When - Act
        seanJoseph.wayOfCalculatingSalary();
    }

    @Test
    public void testFullTimeEmployeeNoBonus() {
        //Given - Arrange
        FullTimeEmployee owenEllis = new FullTimeEmployee("Owen", "Ellis",
                2000, 20, false);

        //When - Act
        owenEllis.wayOfCalculatingSalary();
    }
}
