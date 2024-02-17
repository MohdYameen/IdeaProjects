package DSA;

import java.util.ArrayList;

public class PairSum {

    static boolean isPairSumExist(ArrayList<Integer> arr, int target){
        int lp=0, rp=arr.size()-1;

        while(lp<rp){
            if(arr.get(lp)+arr.get(rp) == target) return true;
            else if(arr.get(lp)+arr.get(rp) < target) lp++;
            else rp--;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        System.out.println(isPairSumExist(arr, 1));
    }
}
