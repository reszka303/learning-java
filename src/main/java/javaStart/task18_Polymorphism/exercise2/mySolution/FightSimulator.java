package javaStart.task18_Polymorphism.exercise2.mySolution;

public class FightSimulator {
    public static void fight(Team team1, Team team2) {
        double team2Energy = attack(team1, team2);
        double team1Energy = attack(team2, team1);
        double energyDifference = team1Energy - team2Energy;
        if (energyDifference > 0) {
            System.out.println("Team wins " + team1.getName() +
                    " with the advantage " +
                    energyDifference + " energy");
        } else if (energyDifference < 0) {
            System.out.println("Team wins " + team2.getName() +
                    " with the advantage " +
                    energyDifference + " energy");
        } else {
            System.out.println("Draw. Both teams have kept " +
                    team1Energy + " energy");
        }
    }

    private static double attack(Team attacker, Team defender) {
        double attack = attacker.sumAttack();
        double defence = defender.sumDefence();
        double energy = defender.sumEnergy();
        double attackPower = attack - defence;
        if (attackPower > 0) {
            return energy - attackPower;
        } else {
            return energy;
        }
    }
}
