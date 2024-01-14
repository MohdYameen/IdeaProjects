package com.yameen;

import java.util.Scanner;

public class PillarGame {

    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] score = new int[n];
        for(int i =0;i<n;i++){
            score[i]=sc.nextInt();
        }
        int pil1 = sc.nextInt();
        int pil2 = sc.nextInt();
        int count = 0;
        for(int i =0;i<n;i++){
            if(pil1%score[i] == 0 && pil2%score[i] == 0){
                count+=1;
            }

        }
        System.out.print("No of players that can win : ");
        System.out.println(count);

    }
}
