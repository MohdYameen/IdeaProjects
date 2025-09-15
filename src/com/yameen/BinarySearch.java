package com.yameen;

public class BinarySearch {

    static int BinarySearch(int [] arr, int target){
        int low = 0, high = arr.length-1;

        while (low<=high){
            int mid = low + (high - low)/2;
            if(target == arr[mid]) return mid;
            else if(arr[mid] < target) low = mid +1;
            else high = mid - 1;
        }
        return -1;
    }

    static int BSLower(int [] a, int find){
        int low = 0;
        int n = a.length;
        int high = n-1;
        int result =-1;
        while(low<=high){
            int mid = (low+high) / 2;
            if(a[mid] == find){
                result = mid;
                high = mid -1;          //if we want lowest position
                //low = mid +1;         // if we want highest position.
            }
            else if(a[mid] > find ){
                high = mid -1;
            }
            else
                low = mid + 1;
        }
        return result;
    }


    static int BSHigher(int [] a, int find){
        int low = 0;
        int n = a.length;
        int high = n-1;
        int result =-1;
        while(low<=high){
            int mid = (low+high) / 2;
            if(a[mid] == find){
                result = mid;
                //high = mid -1;          //if we want lowest position
                low = mid +1;         // if we want highest position.
            }
            else if(a[mid] > find ){
                high = mid -1;
            }
            else
                low = mid + 1;
        }
        return result;
    }

    static int findCount(int [] a, int find){
       /* int count =0;
        //Linear search
        for(int i =0;i<n;i++){
            if(find == a[i]){
                count++;
            }
        }
        return count;

        */
        int n = a.length;
        int first = BSLower(a,find);
        int last = BSHigher(a,find);

        return last - first + 1;

    }

    public static void main(String ... args){
        int arr [] = {1,1,1,3,3,5,5,5,5,5,6,9,9,10,11};
 System.out.println(BinarySearch(arr,6));
      //  System.out.println(BSLowerHigher(arr,8,103));
        //System.out.println(findCount(arr,11,10));
//
//        System.out.println(BSLower(arr,5));
//        System.out.println(BSHigher(arr,5));
//
//        System.out.println(findCount(arr,5));


    }
}