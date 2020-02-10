package modul1.testBraveKnight;

import kodilla.modul1.braveKnight.DeadIslandQuest;
import kodilla.modul1.braveKnight.EliteKnightQuest;
import kodilla.modul1.braveKnight.Knight;
import kodilla.modul1.braveKnight.Quest;
import org.junit.Test;


public class testBraveKnight {
    @Test
    public void testDeadIslandQuest() {
        //Given - Arrange
        Knight knight = new Knight(new DeadIslandQuest());

        //When - Act
        System.out.println(Quest.finishingOfProcess());
    }

    @Test
    public void testEliteKnightQuest() {
        //Given - Arrange
        Knight knight = new Knight(new EliteKnightQuest());

        //When - Act
        System.out.println(Quest.finishingOfProcess());
    }
}
