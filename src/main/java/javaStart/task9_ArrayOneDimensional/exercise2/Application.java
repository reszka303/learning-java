package javaStart.task9_ArrayOneDimensional.exercise2;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        Person[] person = new Person[random.nextInt(10)];
        Elevator elevator = new Elevator();

        elevator.list(person);
        elevator.countPerson(person);
        //elevator.sumWeightOfPerson(person);
        elevator.countWeightOfPerson(person);
        elevator.emptyElevator(person);
    }
}
