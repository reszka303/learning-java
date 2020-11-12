package javaStart.task29_ArraysOperation.Me.exercise1Array.test;

public class Test3 {
    public static void main(String[] args) {
        Integer[] ar = {12,3,5,1,12,6,9,12,15,-8,-1,12,-6,-3,5,7};
        int len = ar.length;
        System.out.println(len);
        int keyToDel = 15;
        int j = 0;
        int i = 0;
        for(; i <len;i++){
            if(ar[i] != keyToDel){
                ar[i-j] = ar[i];
            }
            else
                j++;
        }
        for(int k = i-j + 1; k < i; k++){
            ar[k] = null;
        }
        for (int k = 0 ; k < i - j; k++){
            System.out.print(ar[k]+",");
        }
    }
}
