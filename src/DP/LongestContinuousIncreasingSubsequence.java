package DP;

public class LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        int finalans = 0;
        int ans = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                ans++;
                finalans = Math.max(ans, finalans);
            } else ans = 1;
        }
        return finalans;
    }
    public static void main(String[] args) {
        int [] nums = {1,3,5,4,2,3,4,5};
        System.out.println(findLengthOfLCIS(nums));
    }
}
