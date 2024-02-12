package Recursion;

public class FirstAndLastOccurance {

    public static int firstOccurence(int [] arr, int i, int key){
        if(i == arr.length) return -1;
        if(arr[i] == key) return i;
        return firstOccurence(arr, i+1, key);
    }

    public static int lastOccurence(int []arr, int i, int key){
        if(i < 0) return -1;
        if(arr[i] == key) return i;
        return lastOccurence(arr, i-1, key);
    }
    public static void main(String[] args) {
        int [] arr = {8,3,6,9,5,10,2,5,3,9};
        System.out.println(firstOccurence(arr, 0, 9));
        System.out.println(lastOccurence(arr,arr.length-1, 5));

    }
}
