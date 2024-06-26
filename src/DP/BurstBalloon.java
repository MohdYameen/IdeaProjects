package DP;

public class BurstBalloon {

    static int maxCoins(int [] nums){
        int [][] dp = new int[nums.length][nums.length];

        for(int len=1; len<= nums.length; len++){
            for(int i=0; i<=nums.length - len; i++){
                int j = i+len-1;

                for(int k=i; k<=j; k++){
                    int leftV = 1;
                    int rightV = 1;
                    if(i != 0) leftV=nums[i-1];
                    if(j != nums.length-1) rightV = nums[j+1];
                    
                    int before = 0;
                    int after = 0;
                    if(i != k) before = dp[i][k-1];
                    if(j != k) after = dp[k+1][j];

                    dp[i][j] = Math.max(leftV * nums[k] * rightV + before + after, dp[i][j]);
                }
            }
        }

        return dp[0][nums.length-1];
    }

    public static void main(String[] args) {
        int arr [] = {3,1,5,8};
        System.out.println(maxCoins(arr));
    }
}
