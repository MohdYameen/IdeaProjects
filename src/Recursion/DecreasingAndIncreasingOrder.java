package Recursion;
public class DecreasingAndIncreasingOrder {
    public static void printDecreasingOrder(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecreasingOrder(n-1);
    }

    public static void printIncreasingOrder(int n){

        if(n==1){
            System.out.println(n);
            return;
        }

        printIncreasingOrder(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        //printDecreasingOrder(50);
        printIncreasingOrder(10);
    }
}