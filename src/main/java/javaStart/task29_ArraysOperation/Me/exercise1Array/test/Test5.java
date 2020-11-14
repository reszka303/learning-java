package javaStart.task29_ArraysOperation.Me.exercise1Array.test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numArray = {6, 8, 10, 34, 12, 2};

        System.out.println("Array before to remove an element");
        for (int i = 0; i < numArray.length; i++) {
            System.out.print("[" + numArray[i] + "]");
        }

        System.out.println();
        System.out.print("Enter Element to be deleted: ");
        int element = in.nextInt();
        int[] newArray = new int[numArray.length - 1];

        for(int i = 0; i < numArray.length; i++){
            if(numArray[i] == element){
                // Copy array
                System.arraycopy(numArray, 0, newArray, 0, i);
                System.arraycopy(numArray, i + 1, newArray, i, (numArray.length - (i + 1)));
                break;
            }
        }

        System.out.println("Array elements after deletion-- " );
        for(int i = 0; i < numArray.length; i++){
            System.out.print("[" + numArray[i] + "]");
        }


    }
}
