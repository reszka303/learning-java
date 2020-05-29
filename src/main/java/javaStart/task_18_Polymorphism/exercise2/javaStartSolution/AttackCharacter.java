package javaStart.task_18_Polymorphism.exercise2.javaStartSolution;

public class AttackCharacter extends GameCharacter {
    private double extraAttack;

    public AttackCharacter(String name, int energy, int attack,
                           int defence, double extraAttack) {
        super(name, energy, attack, defence);
        this.extraAttack = extraAttack;
    }

    public double getExtraAttack() {
        return extraAttack;
    }

    public void setExtraAttack(double extraAttack) {
        this.extraAttack = extraAttack;
    }

    @Override
    double totalAttack() {
        return getAttack() + extraAttack * getAttack();
    }
}
