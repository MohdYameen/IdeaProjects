package DP;

public class Fibonacci {

    public static int fib(int n, int [] dp){
        if(n<= 1) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }

    public static int fibTabulation(int n){
        int [] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=1;
        int [] dp = new int[n+1]; 

        System.out.println("Fib Memoization : "+fib(n, dp));
        System.out.println("Fib Tabulation : "+fibTabulation(n));

//        for(int i=1; i<dp.length; i++){
//            System.out.println("Fib of "+i+" : "+dp[i]);
//        }
    }
}
