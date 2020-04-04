package javaStart.application;

import javaStart.logic.Charger;
import javaStart.model.Telephone;

import java.util.Random;

public class AppCharger {
    public static void main(String[] args) {
        Random random = new Random();
        Charger charger = new Charger();
        Telephone telephone1 = new Telephone(
                "Samsung Galaxy",
                "S10",
                random.nextInt(4300) + 2700,
                random.nextInt(99));

        System.out.println(telephone1.getInfo());
        charger.chargeVariable(telephone1);
        charger.chargeSet(telephone1);
        charger.chargeFull(telephone1);


    }
}
