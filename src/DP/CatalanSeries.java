package DP;

public class CatalanSeries {

    // mountain range and count trees, count bst
    static int catalan(int n){
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++){
            int start = 0;
            int end = i-1;
            //int cat = 0;
            while(start < i){
                dp[i]+=dp[start] * dp[end];
                start++;
                end--;
            }
            //dp[i] = cat;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(catalan(n));
    }
}
