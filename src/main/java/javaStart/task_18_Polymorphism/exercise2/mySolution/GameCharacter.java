package javaStart.task_18_Polymorphism.exercise2.mySolution;

public class GameCharacter {
    private String name;
    private double attackPower;
    private double defencePower;
    private double quantityLife;

    public GameCharacter(String name, double attackPower, double defencePower,
                         double quantityLife) {
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.quantityLife = quantityLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getDefencePower() {
        return defencePower;
    }

    public void setDefencePower(double defencePower) {
        this.defencePower = defencePower;
    }

    public double getQuantityLife() {
        return quantityLife;
    }

    public void setQuantityLife(double quantityLife) {
        this.quantityLife = quantityLife;
    }

    double increaseAttackPowerBonus() {
        setAttackPower(attackPower * 0.2);
        return attackPower;
    }

    double increaseDefencePowerBonus() {
        setDefencePower(defencePower * 0.2);
        return defencePower;
    }

    String getInfo() {
        String info =
                "Name: " + name +
                ", Attack power: " + attackPower +
                ", Defence power: " + defencePower +
                ", Quantity of life: " + quantityLife;
        return info;
    }
}
