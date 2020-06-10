package javaStart.task20_Enum.exercise1.JS;

public enum Pizza {
    MARGHERITA(true, true, false, false),
    CAPRICIOSA(true, true, true, false),
    PROSCIUTTO(true, true, false, true);

    private String name;
    private boolean tomatoSauce;
    private boolean cheese;
    private boolean mushroom;
    private boolean ham;

    Pizza(boolean tomatoSauce, boolean cheese,
          boolean mushroom, boolean ham) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.mushroom = mushroom;
        this.ham = ham;
    }

    @Override
    public String toString() {
        String result = name() + "(";
        if (tomatoSauce) {
            result += "tomato sauce";
        } if (cheese) {
            result += ", cheese";
        } if (mushroom) {
            result += ", mushroom";
        } if (ham) {
            result += ", ham";
        } result += ")";
        return result;
    }
}
