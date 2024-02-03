package com.yameen;

public class TernaryOperator {

    public static void main(String[] args) {

        int a =5;
        int b=10;
        int larger =    (a>b)?a:b;
        boolean isEven = (a%2==0)?true:false;
        System.out.println(larger);
        System.out.println(isEven);

        /*
        without break in switch conditions, all conditions will be met once one condition is true

        Java always calls by Value
        change(int a){
        a+=10;
        }
        main(){
        int a = 5
        change(a); a gets changes to 15 in change method only not in main method.
        sop(a) -> 5
        }
         */
        switch (3){
            case 1:
                System.out.println("case 1");
                break;
            case 2:
                System.out.println("case 2");
                break;
            case 3:
                System.out.println("case 3");
                break;
            case 4:
                System.out.println("case 4");
                break;
            case 5:
                System.out.println("case 5");
                break;
            default :
                System.out.println("Default case");
        }
    }
}
