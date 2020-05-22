package javaStart.task7_ControlStructure.exercise2.logic;

import javaStart.task7_ControlStructure.exercise2.model.Telephone;

public class Charger {
    public void chargeVariable (Telephone telephone) {
        int onePercent = telephone.getChargeLevel();
        onePercent++;
        System.out.println("Charge level after used a variable is: " +
                onePercent + "%");
    }

    public void chargeSet (Telephone telephone) {
        int onePercent = telephone.getChargeLevel();
        telephone.setChargeLevel(onePercent + 1);
        System.out.println("Charge level after used setter is: " +
                telephone.getChargeLevel() + "%");
    }

    public void chargeFull (Telephone telephone) {
        int onePercent = telephone.getChargeLevel();

        for (int i = telephone.getChargeLevel(); i < 100 ; i++) {
            onePercent++;
        }
        System.out.println("Charge level after full charge is: " +
                onePercent + "%");
    }
}
