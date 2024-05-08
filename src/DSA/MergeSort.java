package DSA;

public class MergeSort {

    static void conquer(int [] arr, int start_index, int mid, int end_index){
        int [] merged = new int[end_index - start_index + 1];

        int left = start_index;
        int right = mid+1;
        int i =0;

        while (left <= mid && right <= end_index){
            if(arr[left] <= arr[right]){
                merged[i++] = arr[left++]; // we can write ++ in this line as well
                //i++; idx1++;
            }
            else{
                merged[i++] = arr[right++];
                //i++;idx2++;
            }
        }

        while(left <= mid){
            merged[i++] = arr[left++];
        }
        while(right <= end_index){
            merged[i++] = arr[right++];
        }

        for (int j=0, k=start_index;j<merged.length;j++, k++){
            arr[k] = merged[j];
        }
    }

    static void divide(int [] arr, int start_index, int end_index){

        if(start_index >= end_index){
            return;
        }
        int mid = start_index + (end_index - start_index) / 2;
        divide(arr, start_index, mid);
        divide(arr, mid+1, end_index);
        //merge or conquer
        conquer(arr, start_index, mid, end_index);

    }

    public static void main(String[] args) {
        int [] arr = {6,4,2,1,9,8,3,5};
        for(int n:arr){
            System.out.print(n +" ");
        }
        System.out.println();

        divide(arr, 0, arr.length-1);

        System.out.println("After Merge Sort");
        for(int n:arr){
            System.out.print(n +" ");
        }
        System.out.println();

    }
}
