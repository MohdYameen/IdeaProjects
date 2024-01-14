package com.yameen;

public class ReverseArray {
    public static void main(String[] args) {
        int [] a = {10,20,30,40,50};
        int low =0, high = a.length -1;
        for(int i : a)
            System.out.print(i+ " ");
        System.out.println();
        //reverse of an array
        for(int i =0;i<a.length-1;i++){
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
        for(int i : a)
            System.out.print(i+ " ");
        System.out.println();
        /*
        //     1st repeated number;
        boolean flag = true;
        int output = 0;

        int []  b = {10,30,30,40,40};
        for(int i =0;i<b.length;i++){
            int temp = b[i];
            for(int j = i+1;j< b.length;j++){
                if(b[j] == temp) {
                    flag = false;
                    output = temp;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag)
            System.out.println("Not Repeated");
        else {
            System.out.println("Repeated");

            System.out.println(output);
        }

         */
    }
}
