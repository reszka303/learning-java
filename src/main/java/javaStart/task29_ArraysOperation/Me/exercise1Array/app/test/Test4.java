package javaStart.task29_ArraysOperation.Me.exercise1Array.app.test;

public class Test4 {
    private static int initialCapacity = 2;
    private static String[] strings = new String[initialCapacity];

    public static void main(String[] args) {
        strings = create();
        System.out.println("Array length: " + strings.length);
        int resized = strings.length + 1;
        System.out.println("Array resized: " + resized);
    }

    private static String[] create() {
        strings[0] = "ebocie";
        strings[1] = "kopne w plecy";
        return strings;
    }
}
