package com.yameen;

import java.util.*;

public class WiproTopper {

    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        ArrayList <Integer> arlist = new ArrayList<>();
        for(int i = 0; i<s;i++){
            int temp =sc.nextInt();
            arlist.add(temp);
        }
        int n = sc.nextInt();
        Collections.sort(arlist);
        for (int i =s-1; i >= s - n;i--){
            System.out.print(arlist.get(i) + " ");
        }
        System.out.println();






    }

}
