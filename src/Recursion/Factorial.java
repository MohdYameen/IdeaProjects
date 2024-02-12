package Recursion;

public class Factorial {

    public static int printFactorial(int n){
        // for negative numbers
        if(n <= 0) return 0;
        if(n==1){
            return n;
        }
        return n*printFactorial(n-1);
    }

    public static int printSumofNaturalNumbers(int n){
        // for negative numbers
        if(n <= 0) return 0;
        if(n==1){
            return n;
        }
        return n+printSumofNaturalNumbers(n-1);
    }

    public static int printNthFabonacciNumber(int n){
        if(n ==0 || n==1) {
            return n;
        }
        return printNthFabonacciNumber(n-1) + printNthFabonacciNumber(n-2);
    }

    public static int printNumberPower(int n, int pow){
        //if(pow < 0) return -1;
        if(pow == 1) return n;
        return n * printNumberPower(n, pow-1);
    }


    // O(logn)
    public static int optimizedNumberPower(int n, int pow){
        if(pow < 0) return -1;
        if(pow == 1) return n;
        if(pow % 2 != 0) return n * optimizedNumberPower(n, pow/2) * optimizedNumberPower(n, pow/2);
        return optimizedNumberPower(n, pow/2) * optimizedNumberPower(n, pow/2);
    }
    public static void main(String[] args) {

        //printFactorial(5);
        //System.out.println(printSumofNaturalNumbers(5));
        //printSumofNaturalNumbers(5);
        //System.out.println(printNthFabonacciNumber(5));
        System.out.println(printNumberPower(2,10));

    }
}
