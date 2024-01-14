package com.yameen;

import java.util.Scanner;

public class WiproOTP {
    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int passwd = 1;
        while(a > 0){
            int temp = a%10;
            passwd*=temp;
            a=a/10;

        }
        System.out.println(passwd);
    }
}
