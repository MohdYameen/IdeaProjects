package com.yameen;

public class RecursiveSum {

    public static int recCount(int n){
        int sum =0;
        while(n!=0){
            sum+=n;
            n--;
        }
        return sum;
    }
    public static void main(String ... args){
        int a = 5;
        System.out.println(recCount(a));
    }
}
