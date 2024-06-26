package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {50,3,10,7,40,80};
        System.out.println(lengthOfLCIS(nums));
    }
}
