package Recursion;

public class MinJumpArray {

    static int minJumps(int [] arr, int low, int high){
        if(high == low){
            return 0;
        }

        if(arr[low] == 0){
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for(int i =low+1; i<=high && i<=low+arr[low]; i++){
            int jumps = minJumps(arr, i, high);
            if(jumps != Integer.MAX_VALUE && jumps+1 < min ){
                min = jumps+1;
            }
        }
        return min;
    }

//    static int minJumps(int arr[], int l, int h)
//    {
//
//        if (h == l)
//            return 0;
//
//        if (arr[l] == 0)
//            return Integer.MAX_VALUE;
//
//        int min = Integer.MAX_VALUE;
//        for (int i = l + 1; i <= h && i <= l + arr[l];
//             i++) {
//            int jumps = minJumps(arr, i, h);
//            if (jumps != Integer.MAX_VALUE
//                    && jumps + 1 < min)
//                min = jumps + 1;
//        }
//        return min;
//    }


    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int n = arr.length;
        System.out.print(minJumps(arr, 0, n - 1));
    }
}
