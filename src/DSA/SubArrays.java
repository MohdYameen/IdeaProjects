package DSA;

import java.util.ArrayList;
import java.util.List;

public class SubArrays {
    public static void printSubArrays(int []a){
        for (int i =0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                System.out.print("[");

                for (int k=i;k<=j;k++){
                    System.out.print(a[k]+" ");
                }
                System.out.print("]");
                System.out.println();
            }
            System.out.println();
        }
    }
    public static int printNumberOfSubArrays(int []a){
        return a.length*(a.length+1)/2;
    }
    public static void main(String[] args) {
//        int []arr = {2,4,6,8,10};
//        printSubArrays(arr);
//        System.out.println(printNumberOfSubArrays(arr));
        List<List<Integer>> mat = new ArrayList<>();
        List<Integer> fist =  new ArrayList<>();
        fist.add(1);
        fist.add(2);
        fist.add(3);
        List<Integer> fist1 =  new ArrayList<>();
        fist1.add(4);
        fist1.add(5);
        fist1.add(6);
        List<Integer> fist2 =  new ArrayList<>();
        fist2.add(7);
        fist2.add(8);
        fist2.add(8);

        mat.add(fist);
        mat.add(fist1);
        mat.add(fist2);
        int left = 0;
        int right = 0;
        int size = mat.get(0).size();
        System.out.println("size:"+ size);
        for (int i =0;i<mat.get(0).size();i++){
            left += mat.get(i).get(i);
            right += mat.get(i).get(size-1-i);

        }

        System.out.println(right-left);
    }
}
