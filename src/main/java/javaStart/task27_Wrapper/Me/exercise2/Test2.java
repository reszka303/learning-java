package javaStart.task27_Wrapper.Me.exercise2;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        //Char array initiate
        char[] arrayChar = {'q', 'w', 'e', '!', '0', '1', '2'};
        String printArrayChar = Arrays.toString(arrayChar);
        System.out.println("Array of char: " + printArrayChar);
        System.out.println();


        //Convert char array to String array with Stream
        String[] arrayString = Stream.of(arrayChar).map(String::valueOf).toArray(String[]::new);
        String printArrayString = Arrays.toString(arrayString);
        System.out.println("Array of Strings: " + printArrayString);
        System.out.println();

        //Convert from char array to String array with loop for
        int sizeString = arrayChar.length;
        String[] arrayString2 = new String[sizeString];
        
        for (int i = 0; i < arrayString2.length; i++) {
            arrayString2[i] = String.valueOf(arrayChar[i]);
        }

        String printArrayString2 = Arrays.toString(arrayString2);
        System.out.println("Array string 2 is: " + printArrayString2);


        //Convert from String array to a single String
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayString.length; i++) {
            stringBuilder.append(arrayString[i]);
        }
        String string = stringBuilder.toString();
        System.out.println("String: " + string);

        //Count all strings in string array

        int counter = 0;
        for (int i = 0; i < stringBuilder.toString().length(); i++) {
            counter++;
        }

        System.out.println("Array contains: " + counter + " marks");


        //Extract only digits from a single String
        var stringBuilder1 = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char specifiedCharacter = string.charAt(i);
            if (Character.isDigit(specifiedCharacter)) {
                stringBuilder1.append(specifiedCharacter);
            }
        }

        String stringWithDigit = stringBuilder1.toString();
        System.out.println("String 2: " + stringWithDigit);

        //Convert from a single String into int array
        int size = stringWithDigit.length();

        String[] stringNumbers = stringWithDigit.split("");
        int[] integers = new int[size];

        for (int i = 0; i < size ; i++) {
            integers[i] = Integer.parseInt(stringNumbers[i]);
        }

        String arrayInt = Arrays.toString(integers);
        System.out.println("Array of int: " + arrayInt);



//
//        Pattern pattern = Pattern.compile(string);
//        Matcher matcher = pattern.matcher(string);
//
//        while (matcher.find()) {
//            System.out.print("Matcher: " + matcher.group());
//        }
//        System.out.println();

//        int size = string2.length();
//
//
//        Integer[] arrayInteger = new Integer[size];
//        for (int i = 0; i < size; i++) {
//            arrayInteger[i] = Integer.parseInt(arrayString[i]);
//        }
//        String printArrayInteger = Arrays.toString(arrayInteger);
//        System.out.println("Array of Integers: " + printArrayInteger);
    }
}
