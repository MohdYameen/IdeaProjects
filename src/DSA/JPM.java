package DSA;

import java.util.*;

public class JPM {

    public static int computeCost(List<Integer> arr, int N, int X) {
        int cost = 0;
        for (int i = 0; i < N; i++)
            cost += Math.abs(arr.get(i) - X);
        return cost;
    }

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {nums[i], cost[i]};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            long a = arr[i - 1][0], b = arr[i - 1][1];
            f[i] = f[i - 1] + a * b;
            g[i] = g[i - 1] + b;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            long a = arr[i - 1][0];
            long l = a * g[i - 1] - f[i - 1];
            long r = f[n] - f[i] - a * (g[n] - g[i]);
            ans = Math.min(ans, l + r);
        }
        return ans;
    }


    public static int minServers(List<Integer> server, int expected_load) {
        Collections.sort(server);

        int[] dp = new int[expected_load + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int s : server) {
            for (int load = expected_load; load >= s; load--) {
                if (dp[load - s] != Integer.MAX_VALUE) {
                    dp[load] = Math.min(dp[load], dp[load - s] + 1);
                }
            }
        }
        return dp[expected_load] == Integer.MAX_VALUE ? -1 : dp[expected_load];

    }

    public static int minOperation (List<Integer> arr)
    {
        int n = arr.size();
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i=0; i<n; i++)
            if(hash.containsKey(arr.get(i)))
                hash.put(arr.get(i), hash.get(arr.get(i))+1);
            else hash.put(arr.get(i), 1);

        int max_count = 0;
        Set<Integer> s = hash.keySet();

        for (int i : s)
            if (max_count < hash.get(i))
                max_count = hash.get(i);

        return (n - max_count);
    }

    public static int findMinimumCost(List<Integer> arr) {
//        // Write your code here
//        int n= arr.size();
//        Collections.sort(arr);
//        int median;
//        if(n % 2 == 0){
//            median = (arr.get(n/2 -1)+arr.get(n/2))/2;
//        }
//        median = arr.get(n/2);
//
//        int tc = 0;
//        for(int num:arr){
//            tc+=Math.abs(num-median);
//        }
//
//        return tc;


        int low, high;
        int N = arr.size();
        low = high = arr.get(0);
        for (int i = 0; i < N; i++) {
            if (low > arr.get(i))
                low = arr.get(i);
            if (high < arr.get(i))
                high = arr.get(i);
        }

        while ((high - low) > 2) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int cost1 = computeCost(arr, N, mid1);
            int cost2 = computeCost(arr, N, mid2);

            if (cost1 < cost2)
                high = mid2;

            else
                low = mid1;
        }
        return computeCost(arr, N, (low + high) / 2);

    }



    {


    }
    public static void main(String[] args) {

    }
}
