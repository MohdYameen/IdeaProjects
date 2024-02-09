package com.yameen;

public class MagicNumber {
    public static void main(String[] args) {
       /* int a = 1244;
        if(a%9 == 1)
            System.out.println("Magic Number");
        else
            System.out.println("Not a magic number");

        */
        int a = 180;
        int sum =0;
        while(a>0 || sum >9){
            if(a==0){
                a=sum;
                sum=0;
            }
            sum = sum + a%10;
            a=a/10;
        }
        if(sum ==1)
            System.out.println("Magic Number");
        else
            System.out.println("Not magic number");
    }
}
