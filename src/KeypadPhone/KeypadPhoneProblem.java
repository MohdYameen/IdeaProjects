package KeypadPhone;

import java.util.*;

public class KeypadPhoneProblem {

    static List<String> solve(String  number, int n, String [] mapping){
        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()){
            String s = q.remove();
            if(s.length() == n)
                list.add(s);
            else {
                String val = mapping[Character.getNumericValue(number.charAt(s.length()))];
                for(int i=0;i<val.length();i++){
                    q.add(s+val.charAt(i));
                }
            }
        }
        return list;
    }
    public static void letterCombinations(String digits) {
        int n = digits.length();

        String [] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        //List<String> list = solve(digits, n, mapping);

        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()){
            String s = q.remove();
            if(s.length() == n)
                list.add(s);
            else {
                String val = mapping[Character.getNumericValue(digits.charAt(s.length()))];
                for(int i=0;i<val.length();i++){
                    q.add(s+val.charAt(i));
                }
            }
        }

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        String digits = "24";
        letterCombinations(digits);


    }
}
