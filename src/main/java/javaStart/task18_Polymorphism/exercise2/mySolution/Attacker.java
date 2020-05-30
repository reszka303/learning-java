package javaStart.task18_Polymorphism.exercise2.mySolution;

public class Attacker extends GameCharacter {
    private double extraAttack;

    public Attacker(String name, double attack, double defence,
                    double energy, double extraAttack) {
        super(name, attack, defence, energy);
        this.extraAttack = extraAttack;
    }

    public double getExtraAttack() {
        return extraAttack;
    }

    public void setExtraAttack(double extraAttack) {
        this.extraAttack = extraAttack;
    }

    @Override
    double attackBonus() {
        return getAttack() * extraAttack + getAttack();
    }

    @Override
    String getInfo() {
        return super.getInfo() + ", Attack bonus: " + extraAttack;
    }
}
