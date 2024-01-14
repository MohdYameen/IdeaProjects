package com.yameen;

public class BubbleSort {
    public static void mybubblesort (int [] arr){
        for(int i=0;i<arr.length - 1 ; i++ ){
            for(int j=0;j<arr.length -i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void show(int [] arr){
        for(int i =0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String ... args){
        int [] a = {1,2,3,4,5,6,78,5,3};
        show(a);
        mybubblesort(a);
        show(a);
    }
}
