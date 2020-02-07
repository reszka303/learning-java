package kodilla.modul1.maritalAgeControl;

import java.time.LocalDate;

public class Man {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Man(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
