package javaStart.task38_MethodReference.lesson.referenceToMethod;

import java.util.List;
import java.util.function.Consumer;

public class ComputerMethod {
    public static void main(String[] args) {
        List<Computer> computers = List.of(
                new Computer("Lenovo", 3000, 45),
                new Computer("HP", 3200, 66),
                new Computer("Apple", 3400, 78),
                new Computer("Asus", 2800, 42)
        );
        consume(computers, Computer::overclock);
        consume(computers, ComputerMethod::printComputerWithTemperature);
    }

    private static void printComputerWithTemperature(Computer computer) {
        String textToPrint = computer.getName() + " " + computer.getCpu();
        if (computer.getTemperature() < 50)
            textToPrint += "/ cold";
        else
            textToPrint += "/ hot";
        System.out.println(textToPrint);
    }

    private static void consume(List<Computer> list, Consumer<Computer> consumer) {
        for (Computer computer : list) {
            consumer.accept(computer);
        }
    }
}
