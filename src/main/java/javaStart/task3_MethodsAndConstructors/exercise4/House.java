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

    void takeShower() {
        water -= 48;
        setWaterLevel();
    }

    void takeBath() {
        water -= 86;
        setWaterLevel();
    }

    void makeDinner() {
        oil -= 0.1;
        water -= 4;
        setWaterLevel();
        setOilLevel();
    }

    void boilWater() {
        oil -= 0.05;
        water -= 0.5;
        setWaterLevel();
        setOilLevel();
    }

    void watchTV(int hours) {
        double intake = 0.06;
        intake *= hours;
        oil -= intake;
        setOilLevel();
    }

    void heatHouse(int month) {
        double intake = 300;
        intake *= month;
        oil -= intake;
        setOilLevel();
    }

    private String setWaterLevel() {
        if (water <= 0) {
            setWater(water = 0);
        }
        return "";
    }

    private String setOilLevel() {
        if (oil <= 0) {
            setOil(oil = 0);
        }
        return "";
    }

    String fuelWater(double fuel) {
        setWater(water + fuel);
        if (water >= 1000) {
            water = 1000;
            return "A container of water is full";
        }
        return "";
    }

    String fuelOil(double fuel) {
        setOil(oil + fuel);
        if (oil >= 1000) {
            setOil(oil = 1000);
        }
        return "";
    }

    private String fullOil() {
        if (oil >= 1000) {
            return "A container of oil is full";
        }
        return "";
    }

    private String fullWater() {
        if (water >= 1000) {
            return "A container of water is full";
        }
        return "";
    }

    private String infoOilLevel() {
        if (oil <= 100 && oil >= 0.01) {
            return "There is a level of oil below 100 litres" +
                    " in the container";
        } else if (oil <= 0) {
            return "There is no oil in the container" +
                    setOilLevel();
        }
        return "";
    }

    private String infoWaterLevel() {
        if (water <= 100 && water >= 0.01) {
            return "There is a level of water below 100 litres" +
                    " in the container";
        } else if (water <= 0) {
            return "There is no water in the container" +
                    setWaterLevel();
        }
        return "";
    }

    String infoHome() {
        return "Quantity of water is: " + water + " litres" +
                "\n" + "Quantity of oil is: " + oil + " litres " +
                "\n" + infoOilLevel() +
                "\n" + infoWaterLevel() +
                "\n" + setWaterLevel() +
                "\n" + setOilLevel() + fullOil() +
                "\n" + fullWater();
    }
}
