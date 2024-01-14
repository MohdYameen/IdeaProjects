package com.yameen;

public class Array100 {
    public static void main(String ... args){
        int [] arr = new int[1000];
        arr[0] = 1;
        int count = 2;
        for(int i =1;i<1000;i++){
            if(count % 2 == 0 || count % 3 == 0||count % 5 == 0){
                arr[i] = count;
            }
            else{
                i--;
            }
            count++;
        }
        for(int i =0;i<1000;i++){
            System.out.println("arr["+i+"] : "+ arr[i] );
        }
        System.out.println(arr[6]);
    }

}
