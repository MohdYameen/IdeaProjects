package com.yameen;

import java.util.HashMap;

public class TwoSum {

    public static int [] findTwoSum(int [] arr, int sum){

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int target = sum - arr[i];  // 9 -2 = 7 | 9-5 =4 | 9-7 = 2
            if(hashmap.containsKey(target)){ //false | false | true
                return new int [] {hashmap.get(target),i};
            }
            hashmap.put(arr[i],i); // [2,0] | [5,1]
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int [] arr = {2,5,7,11};

        int [] sol = findTwoSum(arr, 123);

//        System.out.println(sol[0]+" "+sol[1]);

    }
}
