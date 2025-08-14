package DP;

public class CoinChange {

    public static int numberOfWays(int []coins, int sum){
        int dp[][] = new int[coins.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
//        for(int []i:dp){
//            for(int j:i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][sum];
    }
    public static void main(String[] args) {
        int [] coins = {2,5,1};
        int sum = 3;
        System.out.println(numberOfWays(coins, sum));


    }
}
