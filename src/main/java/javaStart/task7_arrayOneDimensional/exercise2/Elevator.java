package javaStart.task7_arrayOneDimensional.exercise2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Elevator {
    public Person[] list(Person[] person) {
        Random random = new Random();

        for (int i = 0; i < person.length; i++) {
            person[i] = new Person(random.nextInt(100) + 1, random.nextInt(120) + 3);
            System.out.println("id: " + person[i].getId() + "   weight: " + person[i].getWeight());
        }
        return person;
    }

    public void countPerson(Person[] person) {
        if (person.length <= 4) {
            System.out.println("There are " + person.length + " persons in the elevator");
        } else
            System.out.println("The elevator can seat max 4 person, "
                            + person.length + " persons are too many");
        }

    public int sumWeightOfPerson(Person[] person) {
        int sum = 0;
        for (int i = 0; i < person.length; i++) {
            sum += person[i].getWeight();
        }
        return sum;
    }

    public void countWeightOfPerson(Person[] person) {
        int sum = sumWeightOfPerson(person);
        System.out.println("Total weight of persons in the elevator are: " + sum);
        int counter = 0;

        if (sum <= 400 && person.length <= 4 && person.length != 0) {
            System.out.println("The elevator is running");
        } if (sum > 400) {
            for (int i = 400; i < sum; i++) {
                counter++;
            }
            System.out.println("The elevator is overloaded by "
                    + counter + " kg and it can't run");
        } if (person.length > 4) {
                System.out.println("The elevator can't run because of too many persons are there");
        } if (person.length == 0) {
            System.out.println("There is no person, the elevator don't run");
        }
    }

    public void emptyElevator(Person[] person) {
        int sum = 0;
        if (sum <= 400 && person.length <= 4 && person.length != 0) {
            System.out.println("The elevator is being emptied");
            System.out.println("Please wait...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("The elevator is emptied");
            }
        }
    }
}
