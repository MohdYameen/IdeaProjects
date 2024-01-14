package com.yameen;

public class SelectionSort {
    static void sort(int [] ar){
        int n = ar.length;
        for(int i =0;i<n-1;i++){
            int min_index = i;
            for(int j =i+1; j<n;j++ ){
                if(ar[j] < ar[min_index]){
                    min_index =j;
                }
            }
            int temp = ar[min_index];
            ar[min_index] = ar[i];
            ar[i] = temp;

        }

    }
    static void show (int [] ar ){
        for(int i =0;i<ar.length;i++){
            System.out.print(ar[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String ... args){
        int []a = {1,2,3,4,6,4,32,5,7,99,12};
        show(a);
        sort(a);
        show(a);
    }
}

