package com.yameen;

public class PairsInArray {

    public static void printPairs(int arrayToPrintPairs[]) {
        for (int i=0;i<arrayToPrintPairs.length;i++){
            for(int j=i+1;j<arrayToPrintPairs.length;j++){
                System.out.print("("+arrayToPrintPairs[i]+" "+arrayToPrintPairs[j]+")");
            }
            System.out.println();
        }
    }

    public static int numberOfPairs(int arrayToCountNumberOfPairs[]){
        return arrayToCountNumberOfPairs.length * (arrayToCountNumberOfPairs.length-1) / 2;
    }

    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        printPairs(arr);
        System.out.println("No. of pairs: "+numberOfPairs(arr));



    }
}
