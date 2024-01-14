package com.yameen;

import java.util.Scanner;

public class CountSingleAlphabet {
    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int [] freq = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++){
            freq[s.charAt(i) - 'a']++;
        }
        int count =0;
        for(int i =0;i<26;i++){
            if(freq[i] == 1){
                count+=1;
            }
        }
        System.out.println(count);
    }

}
