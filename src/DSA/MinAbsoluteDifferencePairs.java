package DSA;

import java.util.Arrays;

public class MinAbsoluteDifferencePairs {

    public static void main(String[] args) {
        int [] arr = {4,1,8,7};
        int [] arr2= {2,3,6,5};

        Arrays.sort(arr2);
        Arrays.sort(arr);

        int min=0;
        for(int i=0;i<arr.length;i++){
            min+=Math.abs(arr[i]-arr2[i]);
        }
        System.out.println(min);
    }

}
