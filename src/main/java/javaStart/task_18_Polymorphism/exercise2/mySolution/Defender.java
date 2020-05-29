package javaStart.task_18_Polymorphism.exercise2.mySolution;

public class Defender extends GameCharacter {
    private double defencePowerBonus;

    public Defender(String name, double attackPower, double defencePower,
                    double quantityLife, double defencePowerBonus) {
        super(name, attackPower, defencePower, quantityLife);
        this.defencePowerBonus = defencePowerBonus;
    }

    public double getDefencePowerBonus() {
        return defencePowerBonus;
    }

    public void setDefencePowerBonus(double defencePowerBonus) {
        this.defencePowerBonus = defencePowerBonus;
    }

    @Override
    double increaseDefencePowerBonus() {
        return super.increaseDefencePowerBonus();
    }

    @Override
    String getInfo() {
        return super.getInfo() + ", Defence power bonus: " + defencePowerBonus;
    }
}
