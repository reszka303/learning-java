package javaStart.task18_Polymorphism.exercise2.mySolution;

public class Defender extends GameCharacter {
    private double extraDefence;

    public Defender(String name, double attack, double defence,
                    double energy, double extraDefence) {
        super(name, attack, attack, energy);
        this.extraDefence = extraDefence;
    }

    public double getExtraDefence() {
        return extraDefence;
    }

    public void setExtraDefence(double extraDefence) {
        this.extraDefence = extraDefence;
    }

    @Override
    double defenceBonus() {
        return getDefence() * extraDefence + getDefence();
    }

    @Override
    String getInfo() {
        return super.getInfo() + ", Defence power bonus: " + extraDefence;
    }
}
