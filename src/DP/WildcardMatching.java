package DP;

public class WildcardMatching {

    static boolean wildcardmatch(String s, String p){
        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        //s is empty and p is empty then both matched
        dp[0][0] = true;

        //s is not empty but pattern is empty; false, string will never match empty pattern
        for(int i=1;i<dp.length; i++){
            dp[i][0] = false;
        }
        //set the initial values for dp; s is empty but p is not empty, is last index is * => takes previous value.
        for(int j=1; j<dp[0].length; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    // case    ignore value of * || matched * the last char of s, but still kept it.
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else dp[i][j] = false;

            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "**d";
        System.out.println(wildcardmatch(s,p));

    }
}
