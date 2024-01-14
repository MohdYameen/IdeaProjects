package com.yameen;

public class ArmstrongNumber {
    public static void main(String ... args){
        int a = 373;
        int sum =0, temp =a,r;
        while(temp>0){
            r = temp%10;
            sum += (r*r*r);
            temp/=10;
        }
        if(sum == a){
            System.out.println("Armstrong number");
        }
        else{
            System.out.println("Not Armstrong number");
        }


    }
}
