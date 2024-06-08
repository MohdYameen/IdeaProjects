package DSA;

import java.util.HashSet;
import java.util.Set;

public class CommonElementsIn2Arrays {

    public static int [] common(int []arr, int[]brr){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:arr){
            set1.add(i);
        }
        for(int i:brr){
            set2.add(i);
        }

        set1.retainAll(set2);

        int [] sol = new int[set1.size()];

        int count = 0;
        for(int i:set1){
            sol[count] = i;
            count++;
        }
//        for(int i:sol){
//            System.out.println(i);
//        }
        return sol;

//        for(int i:set1){
//            System.out.print(i+" ");
//        }
//        System.out.println();
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int [] brr = {2,1,6,8,10};
        int []a = common(arr, brr);
        for(int i:a){
            System.out.println(i);
        }
    }
}
