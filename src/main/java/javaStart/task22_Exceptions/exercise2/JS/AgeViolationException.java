package javaStart.task22_Exceptions.exercise2.JS;

public class AgeViolationException extends RuntimeException {
    private final int ageRequired;

    public AgeViolationException(int ageRequired) {
        this.ageRequired = ageRequired;
    }

    public int getAgeRequired() {
        return ageRequired;
    }
}
