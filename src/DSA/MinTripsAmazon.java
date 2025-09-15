package DSA;

import java.util.Arrays;

public class MinTripsAmazon {


    public static int minimumTrips(int warhouseCapacity, int [] vans){

        int [] dp = new int[warhouseCapacity+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0; // no package, no trips

        for(int i=1;i<=warhouseCapacity;i++){
            System.out.print("For warehouse Capacity iteration :"+ i);
            for(int van :vans){
                System.out.println();

                if(i-van >= 0 && dp[i-van] != Integer.MAX_VALUE){
                    System.out.print("Inside inner for loop value of i-van = "+(i-van)+" and dp[i-van] = "+ dp[i-van]);
                    dp[i] = Math.min(dp[i], dp[i-van]+1);
                    System.out.print(" After update dp[i] becomes : "+ dp[i]);
                }
            }
            System.out.println();
        }

        return dp[warhouseCapacity] == Integer.MAX_VALUE? -1:dp[warhouseCapacity];
    }

    public static void main(String[] args) {
        int [] vans = {1,5,7,11};

        System.out.println(minimumTrips(44, vans));

    }
}
