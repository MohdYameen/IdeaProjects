package com.yameen;

import java.util.*;

public class WiproBarcode {

    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        String s = "";
        long rem;
        while(a!=0){
            rem = a %10;
            s = s + (char)('A' + rem - 1 );
            a=a/10;
        }

        for(int i = s.length() -1 ;i>=0;i--){
            System.out.print(s.charAt(i));
        }
        System.out.println();














    }
}
