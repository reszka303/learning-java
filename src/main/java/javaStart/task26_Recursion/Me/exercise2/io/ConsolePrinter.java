package javaStart.task26_Recursion.Me.exercise2.io;

public class ConsolePrinter {


    public void printTotalPrice(double price) {
        if (price > 0) {
            printLine("Price of products is: " + price);
        } else {
            printLine("There is no price due to no product");
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printLineError(String text) {
        System.err.println(text);
    }
}
