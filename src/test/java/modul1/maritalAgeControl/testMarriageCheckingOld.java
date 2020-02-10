package modul1.atm.maritalAgeControl;

import kodilla.modul1.maritalAgeControl.AgeChecker;
import kodilla.modul1.maritalAgeControl.Man;
import kodilla.modul1.maritalAgeControl.Woman;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

public class testMarriageCheckingOld {
    @Test
    public void ageOfMan() {
        //Given - Arrange
        AgeChecker ageChecker = new AgeChecker();
        Man man1 = new Man("Johny", "Cage",
                LocalDate.of(1990,11,14));
        Man man2 = new Man("Joe", "Nebraska",
                LocalDate.of(2003,2,26));

        //When - Act
        LocalDate dateOfBirth1 = man1.getDateOfBirth();
        Period periodMan1 = Period.between(dateOfBirth1, LocalDate.now());
        int yearMan1 = periodMan1.getYears();
        ageChecker.ageOfMan(man1);

        LocalDate dateOfBirth2 = man2.getDateOfBirth();
        Period periodMan2 = Period.between(dateOfBirth2, LocalDate.now());
        int yearMan2 = periodMan2.getYears();
        ageChecker.ageOfMan(man2);

        //Then - Assert
        Assert.assertEquals(29, yearMan1);
        Assert.assertEquals(16, yearMan2);
    }

    @Test
    public void ageOfWoman() {
        //Given - Arrange
        AgeChecker ageChecker = new AgeChecker();
        Woman woman1 = new Woman("Marie", "Lindstroem",
                LocalDate.of(2000,5,2));
        Woman woman2 = new Woman("Sully", "Sue",
                LocalDate.of(2005,1,31));

        //When - Act
        LocalDate dateOfBirthWoman1 = woman1.getDateOfBirth();
        Period periodWoman1 = Period.between(dateOfBirthWoman1,LocalDate.now());
        int yearWoman1 = periodWoman1.getYears();
        ageChecker.ageOfWoman(woman1);

        LocalDate dateOfBirthWoman2 = woman2.getDateOfBirth();
        Period periodOfWoman2 = Period.between(dateOfBirthWoman2, LocalDate.now());
        int yearOfWoman2 = periodOfWoman2.getYears();
        ageChecker.ageOfWoman(woman2);

        //Then - Assert
        Assert.assertEquals(19, yearWoman1);
        Assert.assertEquals(15, yearOfWoman2);
    }

    @Test
    public void methodDisplayingAgeOfMan() {
        //Given - Arrange
        AgeChecker ageChecker = new AgeChecker();
        Man man1 = new Man("Johny", "Cage",
                LocalDate.of(1990,11,14));
        Man man2 = new Man("Joe", "Nebraska",
                LocalDate.of(2003,2,26));

        //When - Act
        ageChecker.ageOfMan(man1);
        ageChecker.ageOfMan(man2);
    }

    @Test
    public void methodDisplayingAgeOfWoman() {
        //Given - Arrange
        AgeChecker ageChecker = new AgeChecker();
        Woman woman1 = new Woman("Marie", "Lindstroem",
                LocalDate.of(2000,5,2));
        Woman woman2 = new Woman("Sully", "Sue",
                LocalDate.of(2005,1,31));

        //When - Act
        ageChecker.ageOfWoman(woman1);
        ageChecker.ageOfWoman(woman2);

    }
}
