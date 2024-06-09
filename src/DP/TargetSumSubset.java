package DP;

public class TargetSumSubset {

    public static boolean targetSum(int [] arr, int sum){
        int n = arr.length;
        boolean [][] dp = new boolean[n+1][sum+1];
        for(int j=0;j<dp.length;j++){
            dp[j][0] = true;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                int value = arr[i-1];
                //valid
                if(value <= j && dp[i-1][j-value]){
                    dp[i][j]=true;
                }
                //exclude and invalid
                else if(dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }

//        to print dp
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp[i].length;j++){
//                System.out.print(dp[i][j]+ " ");
//            }
//            System.out.println();
//        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
         int [] arr = {4,6,7,8,3};
         int sum = 5;
        System.out.println(targetSum(arr,sum));

    }
}
