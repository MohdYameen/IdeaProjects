package com.yameen;

public class TwoMaxNumber {

    public static void main(String ... args){
        int[] a ={1,2,3,4,6,4,7783,5,166,78};
        int top1 = Integer.MIN_VALUE;
        int top2 = Integer.MIN_VALUE;

        for (int i : a) {
            if (top1 < i) {
                top2 = top1;
                top1 = i;
            } else if (top2 < i) {
                top2 = i;
            }
        }
        System.out.println(top1 +" , "+top2);
    }

}
