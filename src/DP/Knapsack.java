package DP;

import java.util.Arrays;

public class Knapsack {

    public static int knapsack(int [] val, int [] wt, int capacity, int n){
        //regular recursion
        if(capacity == 0 || n == 0) return 0;
        if(wt[n-1] <= capacity){
            //include
            int ans1= val[n-1] + knapsack(val, wt, capacity-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, capacity, n-1);

            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, capacity, n-1);
        }
    }

    public static int knapsackMemoization(int [] val, int [] wt, int capacity, int n, int [][]dp){
        if(capacity ==0 || n == 0) return 0;
        if(dp[n][capacity] != -1){
            return dp[n][capacity];
        }

        if(wt[n-1] <= capacity){
            //include
            int ans1= val[n-1] + knapsackMemoization(val, wt, capacity-wt[n-1], n-1,dp);
            //exclude
            int ans2 = knapsackMemoization(val, wt, capacity, n-1,dp);

            dp[n][capacity] = Math.max(ans1, ans2);
            return dp[n][capacity];
        } else {
            dp[n][capacity] = knapsackMemoization(val, wt, capacity, n-1,dp);
            return dp[n][capacity];
        }
    }

    public static int knapsackTab(int [] val, int []wt, int capacity){
        int [][] dp = new int[val.length+1][capacity+1];

        //Arrays.fill(dp[0], 0);
        for(int i=0; i<dp.length; i++){
            dp[i][0]= 0;
        }

        for(int j=0; j<dp[0].length; j++){
            dp[0][j]= 0;
        }


        for(int i=1; i< val.length+1;i++){

            for(int j=1; j<capacity+1; j++){
                int value = val[i-1];
                int weight = wt[i-1];
                if(weight <=j){ //valid
                    //include
                    int incProfilt = value + dp[i-1][j-weight];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfilt, excProfit);
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

//        System.out.println("Print entire table");
//        for(int [] i:dp){
//            for(int j:i){
//                System.out.print(j+", ");
//            }
//            System.out.println();
//        }
        return dp[val.length][capacity];
    }

    public static int unboundedKnapsack(int []val, int []wt, int W){
        int n = val.length;
        int [][]dp = new int[n+1][W+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1; j<dp[i].length; j++){
                if(wt[i-1] <= j){
                    int incItem = val[i-1] + dp[i][j-wt[i-1]];
                    int excItem = dp[i-1][j];
                    dp[i][j] = Math.max(incItem, excItem);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int [] val = {15,14,10,45,30};
        int [] wt =  {2,5,1,3,4};
        int capacity =7;
        System.out.println(knapsack(val, wt, capacity, val.length));

        int [][] dp = new int[val.length+1][capacity+1];
        for (int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
//        for(int []i:dp){
//            for(int j:i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }

        System.out.println("New");
        System.out.println(knapsackMemoization(val, wt, capacity, val.length, dp));
        System.out.println("New Tab");
        System.out.println(knapsackTab(val, wt, capacity));

        System.out.println("Unbounded ");
        System.out.println(unboundedKnapsack(val, wt, capacity));

    }
}
