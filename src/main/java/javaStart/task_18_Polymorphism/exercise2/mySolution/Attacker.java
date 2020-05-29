package javaStart.task_18_Polymorphism.exercise2.mySolution;

public class Attacker extends GameCharacter {
    private double attackPowerBonus;

    public Attacker(String name, double attackPower, double defencePower,
                    double quantityLife, double attackPowerBonus) {
        super(name, attackPower, defencePower, quantityLife);
        this.attackPowerBonus = attackPowerBonus;
    }

    public double getAttackPowerBonus() {
        return attackPowerBonus;
    }

    public void setAttackPowerBonus(double attackPowerBonus) {
        this.attackPowerBonus = attackPowerBonus;
    }

    @Override
    double increaseAttackPowerBonus() {
        return super.increaseAttackPowerBonus();
    }

    @Override
    String getInfo() {
        return super.getInfo() + ", Attack bonus: " + attackPowerBonus;
    }
}
