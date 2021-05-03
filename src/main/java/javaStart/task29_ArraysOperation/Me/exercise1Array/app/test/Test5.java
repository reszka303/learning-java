package javaStart.task29_ArraysOperation.Me.exercise1Array.app.test;

import javaStart.task29_ArraysOperation.Me.exercise1Array.io.DataReader;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.Person;
import javaStart.task29_ArraysOperation.Me.exercise1Array.model.PersonDatabase;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        int[] arr_new = new int[arr.length-1];
        int j = 3;
        for(int i = 0, k = 0; i < arr.length;i++){
            if(i != j){
                arr_new[k] = arr[i];
                k++;
            }
        }
        System.out.println("Before deletion :" + Arrays.toString(arr));
        System.out.println("After deletion :" + Arrays.toString(arr_new));
    }

    public static int [] removeElement (int [] arr, int index) {
        int [] newArr = new int [arr.length - 1];
        int j = 0;
        for (int i = 0; i <arr.length; i ++) {
            if (i != index) {
                newArr [j] = arr [i];
                j ++;
            }

        }
        return newArr;
    }
}
