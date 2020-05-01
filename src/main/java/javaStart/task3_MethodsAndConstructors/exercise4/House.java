package javaStart.task3_MethodsAndConstructors.exercise4;

public class House {
    private double water;
    private double oil;

    public House(double water, double oil) {
        this.water = water;
        this.oil = oil;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public void setOil(double oil) {
        this.oil = oil;
    }

    protected void takeShower() {
        water -= 48;
        System.out.println("We're having a shower");
        setWaterLevel();
    }

     protected void takeBath() {
        water -= 86;
        System.out.println("We're having a bath");
        setWaterLevel();
    }

     protected void makeDinner() {
        oil -= 0.1;
        water -= 4;
        System.out.println("We're making dinner");
        setWaterLevel();
        setOilLevel();
    }

    protected void boilWater() {
        oil -= 0.05;
        water -= 0.5;
        System.out.println("We're boiling some water");
        setWaterLevel();
        setOilLevel();
    }

    protected void watchTV(int hours) {
        double intake = 0.06;
        intake *= hours;
        oil -= intake;
        System.out.println("We're watching TV by " + hours + " hours");
        setOilLevel();
    }

    protected void heatHouse(int month) {
        double intake = 300;
        intake *= month;
        oil -= intake;
        System.out.println("We're heating a house");
        setOilLevel();
    }

    private void reachWaterLowLevel() {
        if (water <= 100 && water >= 1) {
            System.out.println("Water has reached a low level");
        }
    }

    private void reachOilLowLevel() {
        if (oil <= 100 && oil >= 1) {
            System.out.println("Oil has reached a low level");
        }
    }

    private void noWater() {
        if (water <= 0) {
            System.out.println("There is no water");
        }
    }

    private void noOil() {
        if (oil <= 0) {
            System.out.println("There is no oil");
        }
    }

    private void setWaterLevel() {
        if (water <= 0) {
            setWater(water = 0);
        }
    }

    private void setOilLevel() {
        if (oil <= 0) {
            setOil(oil = 0);
        }
    }

    protected void tankWater(double tank) {
        System.out.println("We're tanking a water container");
        setWater(water + tank);
        if (water >= 1000) {
            water = 1000;
            System.out.println("A container of water is full");
        }
    }

    protected void tankOil(double tank) {
        System.out.println("We're tanking a oil container");
        setOil(oil + tank);
        if (oil >= 1000) {
            setOil(oil = 1000);
            System.out.println("A container of oil is full");
        }
    }

    protected void printHome() {
        System.out.println("Quantity of water is: " + water + " litres, " +
                "Quantity of oil is: " + oil + " litres ");
        reachWaterLowLevel();
        reachOilLowLevel();
        noWater();
        noOil();
    }
}
