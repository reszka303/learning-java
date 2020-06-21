package javaStart.task22_Exceptions.exercise2.Me;

import java.util.Objects;

class Competition {
    private String name;
    private int numberParticipant;
    private int ageLimit;


    public Competition(String name, int numberParticipant,
                       int ageLimit) {
        this.name = name;
        this.numberParticipant = numberParticipant;
        this.ageLimit = ageLimit;
    }

    public String getName() {
        return name;
    }

    public int getNumberParticipant() {
        return numberParticipant;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return numberParticipant == that.numberParticipant &&
                ageLimit == that.ageLimit &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberParticipant, ageLimit);
    }

    @Override
    public String toString() {
        return "A number of participants: " + numberParticipant;
    }
}
