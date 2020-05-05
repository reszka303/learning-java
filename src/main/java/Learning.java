import java.util.Scanner;

public class Learning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write something");
        String str = scanner.nextLine();
        while (!str.equals("1")
                && !str.equals("2")
                && !str.equals("3")) {
            System.out.println("Incorrect choice, Try again");
            str = scanner.nextLine();
        }

        switch (str) {
            case "1":
                System.out.println("RUN_EU_FORMAT");
                break;
            case "2":
                System.out.println("two");
                break;
            case "3":
                System.out.println("three");
                break;
        }
    }
}
