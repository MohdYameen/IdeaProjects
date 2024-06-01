package DSA;

import java.util.HashSet;

public class CopyingInExam {

    public static String swapString(String s, int i, int j){
        char[] b = s.toCharArray();
        char temp = b[i];
        b[i] = b[j];
        b[j] = temp;
        return String.valueOf(b);
    }
    public static void generatePermutation(String s, int start, int end, HashSet<String> set){
        if(start == end -1)
            set.add(s+" ");
        else {
            for(int i=start; i<end; i++){
                s = swapString(s, start, i);
                generatePermutation(s, start+1, end,set);
                s = swapString(s, start, i);
            }
        }
    }

    public static int maxDiff(String str, String s){
        int c = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != str.charAt(i) ) c++;
        }
        return c;
    }

    public static void main(String[] args) {
        String[] a = {"abababa","bbj","kj","kk"};

        for(int i=0; i<a.length;i++){
            HashSet<String> set = new HashSet<>();
            String s = a[i];

            generatePermutation(s,0,s.length(), set);
            int max = 0;
            int k = 0;
            for(String str:set){
                k = maxDiff(str, s);
                max = Math.max(max, k);
            }
            System.out.println(max);
        }

    }
}
