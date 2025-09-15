package com.oas;

//class A{
//    int add(int i, int j){
//        return i+j;
//    }
//}

import java.util.Comparator;
import java.util.PriorityQueue;

public class OA1 {

//    static String str;
//
//    public void OA1(){
//        System.out.println("In const");
//        str = "Hello";
//    }

//    private static final long MOD = 1_000_000_007L;
//
//    public long maxSkills(int[] input1, int input2, int input3) {
//        int[] difficulty = input1;
//        int N = difficulty != null ? difficulty.length : 0;
//        int K = input3;
//        if (difficulty == null || N == 0 || K <= 0) return 0L;
//
//        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int val : difficulty) {
//            maxHeap.offer((long) val);
//        }
//
//        long total = 0L;
//        while (!maxHeap.isEmpty()) {
//            long dayProduct = 1L;
//            int picked = 0;
//
//            while (picked < K && !maxHeap.isEmpty()) {
//                long x = maxHeap.poll() % MOD;
//                dayProduct = (dayProduct * x) % MOD;
//                picked++;
//            }
//            total = (total + (dayProduct % MOD)) % MOD;
//        }
//        return total;
//    }


    // Nagarro OA questions
    private static final long MOD = 1_000_000_007L;
    public int lastElement(int input1, int input2) {
        int N = input1, K = input2;
        if (N <= 0 || K <= 0 || K > N) return 0;
        return (int) nCrModPrime(N - 1, K - 1, MOD);
    }

    private long nCrModPrime(int n, int r, long p) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);
        long numer = 1L;
        long denom = 1L;

        for (int i = 1; i <= r; i++) {
            numer = (numer * (n - r + i)) % p;
            denom = (denom * i) % p;
        }
        long denomInv = modPow(denom, p - 2, p);
        return (numer * denomInv) % p;
    }

    private long modPow(long a, long e, long m) {
        long res = 1L;
        a %= m;
        while (e > 0) {
            if ((e & 1L) == 1L) res = (res * a) % m;
            a = (a * a) % m;
            e >>= 1;
        }
        return res;
    }

    public int flipOrFlop(int input1, int[] input2, int input3) {
        int n = input1;
        int[] arr = input2;
        int T = input3;
        if (arr == null || arr.length == 0) return Integer.bitCount(T);
        int x = 0;
        for (int v : arr) x ^= v;
        int need = x ^ T;
        return Integer.bitCount(need);
    }


    public int returnEvenWays(int input1, int[] input2) {
        int n = input1;
        int e = 0, o = 0;
        for (int v : input2) {
            if ((v & 1) == 0) e++;
            else o++;
        }
        long waysEvenParity;
        if (o == 0) {
            waysEvenParity = pow2(e);
        } else {
            waysEvenParity = (pow2(e) * pow2(o - 1));
        }
        long ans = waysEvenParity - 1;
        return (int) Math.max(0L, ans);
    }

    private long pow2(int x) {
        return 1L << x;
    }


    public static void main(String[] args) {

//        short s = 9;
//        System.out.println(add(s, 6));

//        OA1 a = new OA1();
//        System.out.println(str);
//        System.out.println("QQQ");

        try{
            badMethod();
            System.out.println("A");
        }
        catch (Exception ex){
            System.out.println("B");
        }
        finally {
            System.out.println("C");
        }
        System.out.println("D");
    }

    public static void badMethod(){

    }
}
