package javaStart.task12_Looper.exercise3;

import java.util.Scanner;

public class TemperatureControl {
    public static void main(String[] args) {
        int currentTemperature = 0;
        int targetTemperature = 0;
        double temperatureDifference = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Give a present temperature");
        currentTemperature = input.nextInt();
        input.nextLine();
        System.out.println("Give an expected temperature");
        targetTemperature = input.nextInt();
        temperatureDifference = currentTemperature;

        while (temperatureDifference != targetTemperature) {
            System.out.println("Current temperature is as follows: " +
                    temperatureDifference);
            if (temperatureDifference < targetTemperature) {
                temperatureDifference = temperatureDifference + 0.5;
            } else if (temperatureDifference > targetTemperature){
                temperatureDifference = temperatureDifference - 0.5;
            }
        }

        System.out.println("The target temperature has been reached and is as follows:" +
                " " + temperatureDifference + " degrees");
    }
}
