package javaStart.task6_AccessSpecifier.switchTest;

public class SwitchTest {
    public static void main(String[] args) {
        final String name1 = "Gregory";
        final String name2 = "Peter";

        String user = "John";

        switch (user) {
            case name1:
                System.out.println("Hello Greg, what's up?");
                break;
            case name2:
                System.out.println("Good morning Mr. President, how are you?");
                break;
            default:
                System.out.println("Welcome unknow user");
        }
    }
}
