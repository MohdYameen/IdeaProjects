package DSA;

public class SearchRotatedSortedArray {

    static int search(int[] arr, int key){
        int n=arr.length;
        int low=0, high=n-1;
        while (low<=high){
            int mid = (low+high)/2;

            if(arr[mid] == key) return mid;

            //left half is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= key && key <= arr[mid]) high = mid-1;
                else low = mid+1;
            }
            // right half is sorted
            else{
                if(arr[mid] <= key && key <= arr[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {7,8,9,1,2,3,4,5,6};
        System.out.println("Found at index : "+search(arr, 6));

    }
}
