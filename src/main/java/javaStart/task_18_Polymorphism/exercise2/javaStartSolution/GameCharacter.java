package javaStart.task_18_Polymorphism.exercise2.javaStartSolution;

public class GameCharacter {
    private String name;
    private int energy;
    private int attack;
    private int defence;

    public GameCharacter(String name, int energy, int attack, int defence) {
        this.name = name;
        this.energy = energy;
        this.attack = attack;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    double totalAttack() {
        return attack;
    }

    double totalDefence() {
        return defence;
    }
}
