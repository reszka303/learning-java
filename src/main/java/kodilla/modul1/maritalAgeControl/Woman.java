package kodilla.modul1.maritalAgeControl;

import java.time.LocalDate;

public class Woman {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Woman(String name, String surname, LocalDate dateOfBirth) {
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
