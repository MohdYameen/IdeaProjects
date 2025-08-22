package com.practice;//package com.practice;
//
//import java.util.*;
//
////public class Solution {
////
////    public static long getStrength(List<List<Integer>> machine_powers) {
////        int n = machine_powers.size();
////        int m = machine_powers.get(0).size();
////        List<Integer> allPowers = new ArrayList<>(n * m);
////
////        // Flatten all power units into one list
////        for (List<Integer> row : machine_powers) {
////            allPowers.addAll(row);
////        }
////
////        // Sort descending
////        allPowers.sort(Collections.reverseOrder());
////
////        long sumStrength = 0L;
////        // For each machine, the minimum assigned value is at (i+1)*m - 1 after distributing m units to each
////        for (int i = 0; i < n; i++) {
////            int minIdx = (i + 1) * m - 1;
////            sumStrength += allPowers.get(minIdx);
////        }
////
////        return sumStrength;
////    }
////
////    // Example usage:
////    public static void main(String[] args) {
////        List<List<Integer>> machine_powers = Arrays.asList(
////                Arrays.asList(2, 7, 4),
////                Arrays.asList(2, 4, 3)
////        );
////        System.out.println(getStrength(machine_powers)); // Output: 6
////    }
////}
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Solution {
//    public static long getStrength(List<List<Integer>> machine_powers) {
//
//        if (machine_powers == null || machine_powers.isEmpty() || machine_powers.get(0).isEmpty()) {
//            return 0L;
//        }
//        int n = machine_powers.size();
//        int m = machine_powers.get(0).size();
//        List<Integer> allPowers = machine_powers.stream()
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//
//        allPowers.sort(Collections.reverseOrder());
//        long totalStrength = 0L;
//        for (int i = 0; i < n; i++) {
//            int minIndexOfBlock = (i + 1) * m - 1;
//            totalStrength += allPowers.get(minIndexOfBlock);
//        }
//        return totalStrength;
//
//
////        int n = machine_powers.size();            // Number of machines
////        int m = machine_powers.get(0).size();     // Power units per machine
////
////        long maxSum = 0;
////
////        // For each possible way to transfer one unit from each machine (or not):
////        // Since you can only move one unit out from each, try removing each possible unit
////        // and test the configuration.
////        for (int i = 0; i < m; i++) { // Pick i-th unit to remove from machine 1
////            for (int j = 0; j < m; j++) { // from machine 2
////                for (int k = 0; k < m; k++) { // from machine 3
////                    // Construct new lists
////                    List<Integer> m1 = new ArrayList<>(machine_powers.get(0));
////                    List<Integer> m2 = new ArrayList<>(machine_powers.get(1));
////                    List<Integer> m3 = new ArrayList<>(machine_powers.get(2));
////
////                    // Remove selected units
////                    int rm1 = m1.remove(i);
////                    int rm2 = m2.remove(j);
////                    int rm3 = m3.remove(k);
////
////                    // Now try all possible ways of distributing these 3 units back (including possibly to same)
////                    // For simplicity, allow adding all three to any machine
////                    for (int add1 = 0; add1 < 3; add1++) {
////                        for (int add2 = 0; add2 < 3; add2++) {
////                            for (int add3 = 0; add3 < 3; add3++) {
////                                List<Integer> nm1 = new ArrayList<>(m1);
////                                List<Integer> nm2 = new ArrayList<>(m2);
////                                List<Integer> nm3 = new ArrayList<>(m3);
////
////                                // Distribute rm1
////                                if (add1 == 0) nm1.add(rm1);
////                                if (add1 == 1) nm2.add(rm1);
////                                if (add1 == 2) nm3.add(rm1);
////
////                                if (add2 == 0) nm1.add(rm2);
////                                if (add2 == 1) nm2.add(rm2);
////                                if (add2 == 2) nm3.add(rm2);
////
////                                if (add3 == 0) nm1.add(rm3);
////                                if (add3 == 1) nm2.add(rm3);
////                                if (add3 == 2) nm3.add(rm3);
////
////                                // Each machine must have m elements after moving
////                                if (nm1.size() == m && nm2.size() == m && nm3.size() == m) {
////                                    int min1 = Collections.min(nm1);
////                                    int min2 = Collections.min(nm2);
////                                    int min3 = Collections.min(nm3);
////                                    long sum = min1 + min2 + min3;
////                                    if (sum > maxSum) maxSum = sum;
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        }
////
////        return maxSum;
//    }
//
//    // Example usage with your sample case
//    public static void main(String[] args) {
//        List<List<Integer>> machine_powers = Arrays.asList(
//                Arrays.asList(2, 2, 2, 2),
//                Arrays.asList(4, 3, 3, 2),
//                Arrays.asList(2, 5, 3, 3)
//        );
//        System.out.println(getStrength(machine_powers)); // Output: 7
//    }
//}
//

import java.util.*;

public class Solution {

    //this method will be given
    public static int makeStringSteady(String input) {
        int n = input.length();
        int required = n / 4;
        Map<Character, Integer> freq = new HashMap<>();

        char[] letters = {'B', 'D', 'U', 'H'};
        for(char c : letters)
            freq.put(c, 0);


        for (char c : input.toCharArray())
            freq.put(c, freq.get(c) + 1);

        // If already steady
        boolean alreadySteady = true;
        for (char c : letters) {
            if (freq.get(c) > required) {
                alreadySteady = false;
                break;
            }
        }

        if (alreadySteady) return 0;

        int minLen = n;
        int left = 0;
        int[] count = new int[128];
        for (char c : input.toCharArray())
            count[c]++;

        int right = 0;
        while (right < n) {
            count[input.charAt(right)]--;
            while (isSteady(count, required, letters) && left <= right) {
                minLen = Math.min(minLen, right - left + 1);
                count[input.charAt(left)]++;
                left++;
            }
            right++;
        }
        return minLen;
    }

    // new method u have to create
    private static boolean isSteady(int[] count, int required, char[] letters) {
        for (char c : letters) {
            if (count[c] > required) return false;
        }
        return true;
    }

    // Sample usage & test
    public static void main(String[] args) {
        System.out.println(makeStringSteady("HBBBUDBBB")); // Output: 5
        System.out.println(makeStringSteady("HBDU"));      // Output: 0
        System.out.println(makeStringSteady("BBBHUUDDU")); // Output: 2
    }
}

//@Test
//public void testSampleCase1() {
//    assertEquals(5, Solution.makeStringSteady("HBBBUDBBB"));
//}
//
//@Test
//public void testSteadyString() {
//    assertEquals(0, Solution.makeStringSteady("HBDU"));
//}
//
//@Test
//public void testAllOneChar() {
//    assertEquals(3, Solution.makeStringSteady("BBBB"));
//}
//
//@Test
//public void testSingleExcess() {
//    assertEquals(1, Solution.makeStringSteady("BBDU"));
//}
//
//@Test
//public void testLargeSteady() {
//    assertEquals(0, Solution.makeStringSteady("BBDDBBUUHHUUHHDD"));
//}
//
//@Test
//public void testOneReplacement() {
//    assertEquals(1, Solution.makeStringSteady("BBDDHHUUUB"));
//}
//
//@Test
//public void testRemoveFromMiddle() {
//    assertEquals(2, Solution.makeStringSteady("BHBBBUUDDU"));
//}
//
//@Test
//public void testEndImbalance() {
//    assertEquals(3, Solution.makeStringSteady("BUDHBUDHBBBB"));
//}
