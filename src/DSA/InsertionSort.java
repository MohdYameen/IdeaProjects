package DSA;

public class InsertionSort {

    static void insertionSort(int [] arr){

        for(int j=1;j<arr.length;j++){
            int key = arr[j];
            int i = j-1;
            while(i>=0 && arr[i] > key){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }

    static void printArray(int [] arr){
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] arr = {22,13,1,11,10,14,12,9,7};
        printArray(arr);
        System.out.println("Insertion Sort");
        insertionSort(arr);
        printArray(arr);

    }
}
