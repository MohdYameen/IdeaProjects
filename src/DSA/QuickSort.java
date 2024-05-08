package DSA;

public class QuickSort {

    static int partition(int [] arr, int low, int high){
        int pivot = arr[high];
        while(low <= high){
            while(arr[low] < pivot){
                low++;
            }
            while(arr[high] > pivot){
                high--;
            }
            if(low <= high){
                swap(arr, low, high);
                low++; high--;
            }
        }
        return low;
    }

    static void quickSort(int []arr, int low, int high){

        int pi = partition(arr, low, high);
        if(low < pi-1){
            quickSort(arr, low, pi-1);
        }
        if(pi > high){
            quickSort(arr, pi, high);
        }

    }

    static void swap(int [] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    static void printArray(int [] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] arr = {6,3,9,5,2,5,8,7};
        printArray(arr);
        System.out.println("After Quick Sort");

        quickSort(arr,0,arr.length-1);

        printArray(arr);
    }
}
