package javaStart.task_18_Polymorphism.exercise2.javaStartSolution;

public class DefenseCharacter extends GameCharacter {
    private double extraDefense;

    public DefenseCharacter(String name, int energy, int attack, int defence,
                            double extraDefense) {
        super(name, energy, attack, defence);
        this.extraDefense = extraDefense;
    }

    public double getExtraDefense() {
        return extraDefense;
    }

    public void setExtraDefense(double extraDefense) {
        this.extraDefense = extraDefense;
    }

    @Override
    double totalDefence() {
        return getDefence() + extraDefense * getDefence();
    }
}
