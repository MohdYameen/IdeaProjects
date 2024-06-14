package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int lcs(String s1, String s2, int n, int m){
        if(n==0||m==0) return 0;
        else if(s1.charAt(n-1) == s2.charAt(m-1)) return 1 + lcs(s1,s2,n-1, m-1);
        else return Math.max(lcs(s1,s2,n,m-1), lcs(s1,s2,n-1,m));
    }

    static int lcsMemoization(String s1, String s2, int n, int m, int dp[][]){
        if(n==0||m==0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = 1 + lcsMemoization(s1,s2,n-1,m-1,dp);
        }
        else {
            return dp[n][m] = Math.max(lcsMemoization(s1,s2,n,m-1,dp), lcsMemoization(s1,s2,n-1,m,dp));
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdge";
        String s2 = "abedg";
        System.out.println(lcs(s1,s2,s1.length(),s2.length()));
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(lcsMemoization(s1,s2,s1.length(), s2.length(), dp));


//        for(int []n:dp){
//            for(int j:n){
//                System.out.print(j+", ");
//            }
//            System.out.println();
//        }
    }
}
