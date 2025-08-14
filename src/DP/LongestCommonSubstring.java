package DP;

public class LongestCommonSubstring {
    static int longestCommomSubstring(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        int ans = 0;
        int [][] dp = new int[n+1][m+1];

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(dp[i][j], ans);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }



    public static int lcs(String s1, String s2) {
        return lcsRec(s1, s2, s1.length(), s2.length(), 0);
    }
    private static int lcsRec(String s1, String s2, int m, int n, int count) {
        if (m == 0 || n == 0)
            return count;

        int currentCount = count;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            currentCount = lcsRec(s1, s2, m - 1, n - 1, count + 1);
        }

        int count2 = lcsRec(s1, s2, m, n - 1, 0);
        int count3 = lcsRec(s1, s2, m - 1, n, 0);

        return Math.max(currentCount, Math.max(count2, count3));
    }

    public static void main(String[] args) {
        String s1 =  "abcde";
        String s2 = "agbcde";
        System.out.println(longestCommomSubstring(s1,s2));

        System.out.println("Rec");
        System.out.println(lcs(s1,s2));

    }
}
