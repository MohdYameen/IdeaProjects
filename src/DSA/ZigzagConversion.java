package DSA;

import java.util.*;
import java.util.stream.Collectors;

public class ZigzagConversion {

    public static String convert(String s, int numRows){
        if(numRows == 1) return s;
        StringBuilder result = new StringBuilder();

        for(int r=0; r<numRows; r++){
            int increment = 2 * (numRows - 1);
            for(int i=r; i<s.length(); i=i+increment){
                // work for first and last row
                result.append(s.charAt(i));
                //for middle rows
                if(r>0 && r<numRows-1 && i+increment - 2*r < s.length()){
                    result.append(s.charAt(i+increment-2*r));
                }
            }
        }
        return result.toString();
    }


    public static String convert1(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String yam = "mynameisyameen";
        System.out.println(convert(yam, 5));
        System.out.println("new");
        System.out.println(convert1(s, 5));

        Set<Integer> revOrderSet = new LinkedHashSet<>();
        revOrderSet.add(5);
        revOrderSet.add(3);
        revOrderSet.add(1);
        revOrderSet.add(4);
        System.out.println(revOrderSet);
        ArrayList<Integer> arrayList = new ArrayList<>(revOrderSet);
        Collections.reverse(arrayList);
//
//        for(Integer i: revOrderSet){
//            System.out.println(i);
//
//        }

    }
}
