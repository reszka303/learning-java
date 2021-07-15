package differentTasks.passwordValidator.validatorBasic;

//Java Check a String for Lowercase/Uppercase Letter, Special Character and Digit
//https://www.baeldung.com/java-lowercase-uppercase-special-character-digit-regex

public class ValidatorBasic {
    public static void main(String[] args) {
        printLine("Sprawdź siłę swojego hasła:");
        String password = "A1ćCDfE";
        printLine("Twoje hasło to: " + password);
        isSafe(password);
    }

    private static void isSafe(String password) {
        if (!isRightLength(password)) {
            printLine("Hasło musi zawierać co najmniej 5 liter");
        } else if (!isLowerCase(password)) {
            printLine("Hasło musi zawierać co najmniej jedną małą literę");
        } else if (!isUpperCase(password)) {
            printLine("Hasło musi zawierać co najmniej jedną dużą literę");
        } else if (!isDigit(password)) {
            printLine("Hasło musi zawierać co najmniej jedną cyfrę");
        } else if (!isSpecialCharacter(password)) {
            printLine("Hasło musi zawierać co najmniej jeden znak specjalny");
        } else {
            printLine("Hasło spełnia wszystkie kryteria bezpieczeństwa");
        }
    }

    private static boolean isSpecialCharacter(String password) {
        String specialCharacter = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        int capacity = password.length();
        int counterSpecialCharacter = 0;
        char currentCharacter;
        for (int i = 0; i < capacity; i++) {
            currentCharacter = password.charAt(i);
            if (specialCharacter.contains(String.valueOf(currentCharacter))) {
                counterSpecialCharacter++;
            }
        }
        return counterSpecialCharacter >= 1;
    }

    private static boolean isDigit(String password) {
        char[] chars = password.toCharArray();
        int counterDigits = 0;
        for (char character : chars) {
            if (Character.isDigit(character))
            counterDigits++;
        }
        return counterDigits >= 1;
    }

    private static boolean isUpperCase(String password) {
        int counterUpperCase = 0;
        char[] chars = password.toCharArray();
        for (char character : chars) {
            if (Character.isUpperCase(character)) {
                counterUpperCase++;
            }
        }
        return counterUpperCase >= 1;
    }

    private static boolean isLowerCase(String password) {
        char[] chars = password.toCharArray();
        int counterLowerCase = 0;
        for (char character : chars) {
            if (Character.isLowerCase(character)) {
                counterLowerCase++;
            }
        }
        return counterLowerCase >= 1;
    }

    private static boolean isRightLength(String password) {
        char[] chars = password.toCharArray();
        return chars.length >= 5;
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
