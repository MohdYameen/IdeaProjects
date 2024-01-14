package com.yameen;

public class CernerArray {
    public static void main(String[] args) {
        int [] ar = {1,2,3,-6,1};
        int count =0;
        for(int i =0;i<ar.length - 3; i++){
            if(ar[i]+ar[i+1]+ar[i+2]+ar[i+3] == 0)
                count++;
        }
        System.out.println(count);
    }

}
