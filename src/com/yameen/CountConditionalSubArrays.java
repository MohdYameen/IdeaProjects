package com.yameen;

import com.sun.media.sound.SF2Instrument;

import java.util.HashMap;

public class CountConditionalSubArrays {

    public static int countSubarrays(int[] nums) {
        int sol = 0;
        for(int i=0; i<nums.length-2;i++){
            float left = nums[i]+ nums[i+2];
            float right = (float)nums[i+1]/2;
            System.out.println("left "+ left);
            System.out.println("right "+ right);
            if(left == right && nums[i+1] != 1 && nums[i+1] != -1) sol++;
            System.out.println(i+1+ " iteration");
            // if(nums[i]+ nums[i+2] == nums[i+1]/2 && nums[i+1] != 1 && nums[i+1] != -1){
            //     sol++;
            // }
        }
        return sol;
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums) {
            System.out.println(x);
            int digits = 0;
            for (; x > 0; x /= 10){
                System.out.println(digits);
                digits++;
            }
            System.out.println("INternal loop ended");
            System.out.println("Final digit: "+ digits);
            if ((digits & 1) == 0)
                count++;
        }
        return count;
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int [] num : dominoes){

            int min = Math.min(num[0], num[1]);
            int max = Math.max(num[0], num[1]);
            String key = min+","+max;
//            System.out.println(key);
            hashMap.put(key, hashMap.getOrDefault(key,0)+1);
        }

        for(int i: hashMap.values()){
            System.out.println("i value "+i);
            count += i *(i-1)/2;
            System.out.println("count : "+ count);
        }

        return count;
    }

    public static void main(String[] args) {
        int [] array = {12,345,2,6,7896};
//        System.out.println(countSubarrays(array));
//        int a =10;
//        String s = String.valueOf(a);
//        s.length();
//
//        float a = -5;
//        float b = a/2;
//        System.out.println(b);
        int [][] dom = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numEquivDominoPairs(dom));
    }
}
