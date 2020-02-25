package javaStart.task3_MethodsAndConstructors;

public class Calc {

    public int add(int a, int b){
        return a + b;
    }

    public void displayingAdd(int x, int y) {
        int result = add(x, y);
        System.out.println(result);
    }
}
