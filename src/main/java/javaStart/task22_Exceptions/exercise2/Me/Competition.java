package javaStart.task22_Exceptions.exercise2.Me;

public class Competition {
    private String name;
    private int maxParticipant;
    private int ageLimit;

    public Competition(String name, int maxParticipant, int ageLimit) {
        this.name = name;
        this.maxParticipant = maxParticipant;
        this.ageLimit = ageLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }
}
