package com.yameen;

public class ArrayEqualSumDivide {

    public static int findEqualPartition(int [] arr){
        int totalSum = 0;
        for(int n:arr){
            totalSum+=n;
        }
        System.out.println("Total sum: "+totalSum);
        int leftSum = 0;
        for(int i =1; i<arr.length-1; i++){
            leftSum += arr[i-1];
            System.out.println("i : "+i);
            System.out.println("left sum : "+leftSum);
            int rightSum = totalSum - leftSum - arr[i];
            System.out.println("right sum : "+rightSum);
            if(leftSum == rightSum)
                return i;
        }
        return -1;
    }

    public static int [] sortArr(int [] arr){
        int zero=0, one=0, two=0;
        for(int n:arr){
            if(n==0)
                zero++;
            else if(n==1)
                one++;
            else
                two++;
        }

        System.out.println(zero+ " "+one+" "+two+" ");

        int [] newArr =  new int[arr.length];

        for(int i=0;i<zero;i++){
            System.out.println("i in first;"+ i);
            newArr[i]=0;
        }

        for(int i=zero;i<zero+one;i++){
            System.out.println("i in second;"+ i);
            newArr[i]=1;
        }
        for(int i=zero+one;i<arr.length;i++){
            System.out.println("i in third;"+ i);
            newArr[i]=2;
        }

//        for(int i=1;i<arr.length;i++){
//            if(i<=zero)
//                newArr[i-1]=0;
//            if(i> zero && i<=1)
//                newArr[i-1]=1;
//            if(i>one && i<=two)
//                newArr[i-1]=2;
//
//        }
        return newArr;
    }

    public static void main(String[] args) {

        int [] arr = {2,0,2,0,0,0,2,2,1};
//        System.out.println(findEqualPartition(arr));
        for(int n: sortArr(arr)){
            System.out.print(n+" ");
        }
    }
}
