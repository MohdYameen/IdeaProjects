package com.datastructure;

public class MergeSort {
/*
    int array[];
    int tempArray[];
    int length;

    void sort(int inputArray [] ){
        this.array = inputArray;
        this.length = inputArray.length;
        this.tempArray = new int[length];
        divideArray(0,length-1);
    }


    void divideArray(int lower, int higher){
        if(lower<higher){
            int middle = lower + (higher - lower)/2;
            divideArray(lower, middle);
            divideArray(middle+1,higher);
            mergeArray(lower,middle,higher);
        }
    }

    void mergeArray(int lower, int middle, int higher){
        for(int i =lower;i<=higher;i++){
            tempArray[i]=array[i];
        }
        int i =lower;
        int j = middle;
        int k =lower;
        while(i<=middle && j<=higher){
            if(tempArray[i] <= tempArray[j]){
                array[k] = tempArray[i];
                i++;
            }
            else{
                array[k]=tempArray[j];
                j++;
            }
            k++;
        }
        while (i<=middle){
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }


    public static void main(String[] args) {
        int ar [] = {48,36,13,52,19,94,21};
        MergeSort ms = new MergeSort();
        ms.sort(ar);




    }
*/

    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            sort(arr, l, m);
            sort(arr , m+1, r);

            merge(arr, l, m, r);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {48,36,13,52,19,94,21};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
