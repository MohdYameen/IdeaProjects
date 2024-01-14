package com.yameen;

import java.util.Scanner;

public class WiproReverseStringCount {
    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        String org = sc.nextLine();
        String rev = "";
        for(int i =org.length()-1;i>=0;i--){
            rev+=org.charAt(i);
        }
        int count = 0;
        for(int i =0;i<org.length();i++){
            if(org.charAt(i) == rev.charAt(i)){
                count+=1;
            }
        }
        System.out.println(org);
        System.out.println(rev);
        System.out.println(count);
    }
}
