package com.yameen;

import java.util.Scanner;

public class SoldierProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] sol = new int [N];
        for(int i =0; i<N; i++) {
            sol[i] = i+1;
        }

        for(int i:sol)
            System.out.print(i+" ");
    }



}
