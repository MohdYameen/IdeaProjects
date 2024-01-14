package com.yameen;

import java.util.Arrays;

public class InsertionSort {
    static void mysort(int [] ar){
        int n= ar.length;
        for(int i =1;i<n;i++){
            int key = ar[i];
            int j = i-1;
            while(j>=0 && ar[j]>key){
                ar[j+1] = ar[j];
                j=j-1;
            }
            ar[j+1] = key;
        }
    }
    static void show(int [] ar){
        for(int i =0;i<ar.length;i++){
            System.out.print(ar[i] + " " );
        }
        System.out.println();
    }
    public static void main(String ... args){
        int []a = {2,3,4,5,3,4,5,2};
        show(a);
        mysort(a);
        show(a);
    }


}
