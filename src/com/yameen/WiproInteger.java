package com.yameen;

import java.util.Scanner;

public class WiproInteger {
    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ans1 =0;
        int ans2 =0;
        int ans3 =0;
        int ans4 = 0;
        int A,B,C;
        for(int i =0;i<4;i++) {
            A = a%10;
            B = b%10;
            C = c%10;

        if(i == 0){
            if( A >= B && A >= C){
                ans4 = A;
            }
            else if(B >= A && B >= C){
                ans4 = B;
            }
            else if(C > A && C > B){
                ans4 = C;
            }
        }
        if(i == 1){
            if(A <= B && A <= C){
                ans3 = A;
            }
            else if(B < A && B < C){
                ans3 = B;
            }
            else if(C <= A && C <= B ){
                ans3 = C;
            }

        }
        if(i ==2 ){
            if( A >= B && A >= C){
                ans2 = A;
            }
            else if(B >= A && B >= C){
                ans2 = B;
            }
            else if(C >= A && C >= B){
                ans2 = C;
            }
        }
        if(i == 3){
            if(A <=B && A <= C){
                ans1 = A;
            }
            else if(B <= A && B <= C){
                ans1 = B;
            }
            else if(C <= A && C <= B ){
                ans1 = C;

            }

        }
        a=a/10;
        b=b/10;
        c=c/10;

        }
        System.out.println(ans1 + ""+ans2+""+ans3+""+ans4);


    }
}
