package com.yameen;
//recursive program for Longest common subsequece
public class LCS {
    public static int LCS(String x, String y, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }
        else if (x.charAt(n-1) == y.charAt(m-1) ) {
            return 1 + LCS(x, y, n-1, m-1);
        }
        else{
        return Math.max(LCS(x, y, n, m-1) , LCS(x,y,n-1,m));
        }
    }
    public static void main(String ... args){
        System.out.println(LCS("abc", "abc", 3,3));
    }
}
