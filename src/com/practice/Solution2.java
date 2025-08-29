package com.practice;
import java.util.*;

public class Solution2 {
    static class State implements Comparable<State> {
        int digit, configIdx;
        String seq;
        State(int digit, int configIdx, String seq) {
            this.digit = digit;
            this.configIdx = configIdx;
            this.seq = seq;
        }
        public int compareTo(State o) {
            // Shortest first, then lex smallest
            if (this.seq.length() != o.seq.length())
                return this.seq.length() - o.seq.length();
            return this.seq.compareTo(o.seq);
        }
    }

    public static String missingDigits(String config, int x, int y) {
        int n = config.length();

        Map<Integer, Set<Integer>> visited = new HashMap<>();
        PriorityQueue<State> pq = new PriorityQueue<>();

        for (int start : new int[] {x, y}) {
            int d = start % 10;
            int nextConfigIdx = (d == config.charAt(0) - '0') ? 1 : 0;
            pq.offer(new State(d, nextConfigIdx, String.valueOf(d)));
            visited.computeIfAbsent(d, z -> new HashSet<>()).add(nextConfigIdx);
        }

        while (!pq.isEmpty()) {
            State s = pq.poll();
            if (s.configIdx == n) return s.seq;

            for (int add : new int[]{x, y}) {
                int nextDigit = (s.digit + add) % 10;
                int nextConfigIdx = s.configIdx;
                if (nextConfigIdx < n && nextDigit == config.charAt(nextConfigIdx) - '0') {
                    nextConfigIdx++;
                }

                Set<Integer> set = visited.get(nextDigit);
                if (set == null || !set.contains(nextConfigIdx)) {
                    if (set == null) set = new HashSet<>();
                    set.add(nextConfigIdx);
                    visited.put(nextDigit, set);
                    pq.offer(new State(nextDigit, nextConfigIdx, s.seq + nextDigit));
                }
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        System.out.println(missingDigits("324", 2, 3)); // Output: 36924
        System.out.println(missingDigits("521", 5, 5)); // Output: -1

        int[] arr = {-7, 4, 1, 5, 2, -4, 2, 5, 0};

        System.out.println("eq index : "+findEquilibirumIndex(arr));


    }


    public static int findEquilibirumIndex(int [] arr){
        int totalSum=0;
        for(int i:arr){
            totalSum+=i;
        }


        int leftSum = 0;

        for(int i=0;i<arr.length;i++){
            int rightSum = totalSum - leftSum - arr[i];
            if(leftSum == rightSum)
                return i;

            leftSum+=arr[i];
        }

        return -1;

    }
}


//
//public class Solution2 {
//    static class State {
//        int digit;
//        int configIdx;
//        String seq;
//        State(int digit, int configIdx, String seq) {
//            this.digit = digit;
//            this.configIdx = configIdx;
//            this.seq = seq;
//        }
//    }
//
//    public static String missingDigits(String config, int x, int y) {
//        int n = config.length();
//        Set<String> visited = new HashSet<>();
//        Queue<State> q = new LinkedList<>();
//
//        // Try both possible starting digits (x and y)
//        for (int start : new int[] {x, y}) {
//            int d = start % 10;
//            int nextConfigIdx = (d == (config.charAt(0) - '0')) ? 1 : 0;
//            State st = new State(d, nextConfigIdx, "" + d);
//            q.offer(st);
//            visited.add(d + "_" + nextConfigIdx);
//        }
//
//        while (!q.isEmpty()) {
//            State s = q.poll();
//            if (s.configIdx == config.length()) return s.seq;
//
//            for (int add : new int[]{x, y}) {
//                int nextDigit = (s.digit + add) % 10;
//                String newSeq = s.seq + nextDigit;
//                int nextConfigIdx = s.configIdx;
//                if (nextConfigIdx < config.length() && nextDigit == (config.charAt(nextConfigIdx) - '0')) {
//                    nextConfigIdx++;
//                }
//                String key = nextDigit + "_" + nextConfigIdx;
//                if (!visited.contains(key)) {
//                    visited.add(key);
//                    q.offer(new State(nextDigit, nextConfigIdx, newSeq));
//                }
//            }
//        }
//        return "-1";
//    }
//
//    public static void main(String[] args) {
//        System.out.println(missingDigits("324", 2, 3)); // Output: 36924
//        System.out.println(missingDigits("521", 5, 5)); // Output: -1
//    }
//}


//public class Solution2 {
//    public static String missingDigits(String config, int x, int y) {
//        int n = config.length();
//        char[] target = config.toCharArray();
//        List<Integer> starts = Arrays.asList(x, y);
//        String result = null;
//
//        for (int start : starts) {
//            Queue<State> queue = new LinkedList<>();
//            queue.offer(new State(start % 10, 0, String.valueOf(start % 10)));
//
//            HashMap<String, String> visited = new HashMap<>();
//
//            while (!queue.isEmpty()) {
//                State state = queue.poll();
//
//                if (state.pos == n) {
//                    if (result == null || state.sequence.compareTo(result) < 0) {
//                        result = state.sequence;
//                    }
//                    continue;
//                }
//
//                if (state.sequence.charAt(state.sequence.length() - 1) == target[state.pos]) {
//                    String key = state.digit + "_" + (state.pos + 1);
//                    String found = visited.get(key);
//                    if (found == null || state.sequence.compareTo(found) < 0) {
//                        visited.put(key, state.sequence);
//                        queue.offer(new State(state.digit, state.pos + 1, state.sequence));
//                    }
//                }
//
//                for (int add : new int[]{x, y}) {
//                    int nextDigit = (state.digit + add) % 10;
//                    String nextSeq = state.sequence + nextDigit;
//                    String key = nextDigit + "_" + state.pos;
//                    String found = visited.get(key);
//                    if (found == null || nextSeq.compareTo(found) < 0) {
//                        visited.put(key, nextSeq);
//                        queue.offer(new State(nextDigit, state.pos, nextSeq));
//                    }
//                }
//            }
//        }
//        return result == null ? "-1" : result;
//    }
//
//    static class State {
//        int digit;
//        int pos;
//        String sequence;
//
//        State(int digit, int pos, String sequence) {
//            this.digit = digit;
//            this.pos = pos;
//            this.sequence = sequence;
//        }
//    }
//
//    // Example usage with sample test cases:
//    public static void main(String[] args) {
//        System.out.println(missingDigits("324", 2, 3)); // Output: 36924
//        System.out.println(missingDigits("521", 5, 5)); // Output: -1
//    }
//}
