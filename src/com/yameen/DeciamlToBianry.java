package com.yameen;

public class DeciamlToBianry {
    public static void main(String ... args){
        int a = 56;
        String s ="";
        while(a>0){
            int temp = a % 2;
            s = s + temp;
            a/=2;
        }
        for(int i =s.length() -1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
        System.out.println();
        int btemp;
        int binary = 111000;
        double result =0;
        int j =0;
        while(binary > 0){
            btemp = binary%10;
            result += btemp * Math.pow(2,j);
            j++;

            binary/=10;

        }
        System.out.println(result);


    }
}
