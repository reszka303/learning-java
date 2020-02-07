package kodilla.modul1.maritalAgeControl;

import java.time.LocalDate;
import java.time.Period;

public class AgeChecker {

    public void ageOfMan(Man man) {
        LocalDate dateOfBirth = man.getDateOfBirth();
        Period period = Period.between(dateOfBirth, LocalDate.now());
        if (period.getYears() >= 18) {
            System.out.println(man.getName() + " " + man.getSurname() + " "
                    + "has " + period.getYears() + " years that's why he can get married.");
        } else {
            System.out.println(man.getName() + " " + man.getSurname() + " "
                    + "has " + period.getYears() + " that's why he can't get married.");
        }
    }

    public void ageOfWoman(Woman woman) {
        LocalDate dateOfBirth = woman.getDateOfBirth();
        Period period = Period.between(dateOfBirth, LocalDate.now());
        if (period.getYears() >= 16) {
            System.out.println(woman.getName() + " " + woman.getSurname() + " "
            + "has " + period.getYears() + " years that's why she can get married.");
        } else {
            System.out.println(woman.getName() + " " + woman.getSurname() + " "
                    + "has " + period.getYears() + " that's why she can't get married.");
        }
    }
}
