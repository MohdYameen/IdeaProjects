package com.yameen;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static int romanToInteger(String s){
        int sum = 0;
        int n = s.length();

        for (int i=0;i<n;i++){
            char ch = s.charAt(i);
            System.out.println("i  "+i);
            System.out.println("char  "+ ch);
            System.out.println("curr val "+getVal(ch));
            if(i<n-2){
                System.out.println("next val "+getVal(s.charAt(i+1)));
            }

            if((i+1) < n && getVal(ch) < getVal(s.charAt(i+1))){
                sum = sum - getVal(ch);
            } else {
                sum = sum + getVal(ch);
            }

            System.out.println("Current sum : "+sum);
            System.out.println("**************************************");
        }
        return sum;
    }

    public static int getVal(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }

    public static void main(String[] args) {
        String s = "LIV";
        System.out.println(romanToInteger(s));
    }
}