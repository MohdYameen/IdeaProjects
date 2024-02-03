package com.yameen;

public class MaxSubArraySum {
    public static int maxSubArraySum(int []a){
        int max_sum = Integer.MIN_VALUE;
        int current_sum =0;
        for (int i =0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                current_sum =0;
                for (int k=i;k<=j;k++){
                    current_sum+=a[k];
                }
                if(current_sum > max_sum){
                    max_sum = current_sum;
                }
            }
        }
        return max_sum;
    }
    public static void main(String[] args) {
        int [] arr = {1,-2,6,-3,3};
        System.out.println("Max Sub Array Sum: "+maxSubArraySum(arr));
    }
}
