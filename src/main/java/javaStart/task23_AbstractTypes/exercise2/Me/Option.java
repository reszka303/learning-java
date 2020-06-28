package javaStart.task23_AbstractTypes.exercise2.Me;

public enum Option {
    EXIT(0, "Exit the program"),
    ADD_EMPLOYEE_FULL_TIME(1, "Addition employee full-time"),
    ADD_EMPLOYEE_PART_TIMER(2, "Addition employee part-timer"),
    PRINT_EMPLOYEE_FULL_TIME(3, "Display employee full-time"),
    PRINT_EMPLOYEE_PART_TIMER(4, "Display employee part-timer");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static Option createFromInt(int option) throws NoSuchOptionException {
        try {
         return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("No option with id" + option);
        }
    }
}
