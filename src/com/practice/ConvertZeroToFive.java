package com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertZeroToFive {

    public static int convertToFive(int n){
        if(n == 0) return 0;
        int digit = n%10;
        if(digit == 0) digit =5;
        return convertToFive(n/10)*10+digit;
    }

    public static int find3rdLargest(int [] arr){
        int first = arr[0];
        int sec = 0;
        int third = 0;

        for(int i: arr){
            if(i>first){
                third = sec;
                sec = first;
                first = i;
            } else if(i>sec){
                third = sec;
                sec=i;
            }else if(i>third){
                third = i;
            }
        }
        return third;
    }

    public static List<Integer> maxAnd2ndMax(int [] arr){
        List<Integer> list = new ArrayList<>();
        int first = arr[0];
        int second = 0;
        for(int i:arr){
            if(i>first){
                second = first;
                first = i;
            } else if(i>second){
                second = i;
            }
        }
        list.add(first);
        list.add(second);
        return list;
    }

    public static int minDistance(int [] arr, int a, int b){
        int dist = Integer.MAX_VALUE;
        // brute force approach
//        for(int i=0; i< arr.length; i++){
//            for(int j=i+1; j<arr.length; j++){
//                if((a == arr[i] && b == arr[j] || a == arr[i] && b == arr[j]) && dist> Math.abs(i-j)){
//                    dist = Math.abs(i-j);
//                }
//            }
//        }

        // better approach
        int onePos =-1, twoPos = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==a){
                onePos=i;
            }
            if (arr[i]==b) {
                twoPos=i;
            }
            if(onePos != -1 && twoPos != -1){
                dist = Math.min(dist, Math.abs(onePos-twoPos));
            }
        }
        return dist;
    }

    // two pointer approach very simple
    public static int [] reverseArrray(int [] arr){
        int left=0;
        int right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return arr;
    }

    // very basic
    public static void removeDuplicates(List<Integer> arr){
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);

        // for prime number we can use product method, prod *= arr[i]
        // if prod%arr[i] != 0
    }

    // very simple approach for prime number
    // multiple everything to product, if prod%arr[i] != 0, then add arr[i] tp ans list and prod *= arr[i];
    // continue
    public static List<Integer> removeDupFromSmallPrimeNoArray(int [] arr){

        List<Integer> ans = new ArrayList<>();

        long prod=arr[0];
        ans.add(arr[0]);

        for(int i=1; i<arr.length;i++){
            if(prod%arr[i] !=0){
                ans.add(arr[i]);
                prod *= arr[i];
            }
        }

        return ans;

    }

    public static int maxSumPath2Arrays(int [] ar1, int [] ar2){
        /*
        int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
        int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };

        min of i,j in sum1 or sum2 until both value are same,
        will take max of sum1,sum2 plus same value and add it in final result
        whateven reached end first, remaing one willl iterate till end
        and will do final comparison of sum1, sum2
        directly add it to final result

        */
        int m = ar1.length;
        int n = ar2.length;
        int i = 0, j = 0;

        int result = 0, sum1 = 0, sum2 = 0;

        while (i < m && j < n) {
//            System.out.println();
//            System.out.println("i = "+i+" j="+j);
            if (ar1[i] < ar2[j]){
                sum1 += ar1[i++];
//                System.out.println("sum1 : "+sum1);
            }

            else if (ar1[i] > ar2[j]){
                sum2 += ar2[j++];
//                System.out.println("sum2 : "+ sum2);
            }

            else {
                result += Math.max(sum1, sum2) + ar1[i];
//                System.out.println("result : "+result);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

//        System.out.println("while loop ended here ");
        while (i < m)
            sum1 += ar1[i++];

        while (j < n)
            sum2 += ar2[j++];

        result += Math.max(sum1, sum2);

        return result;
    }


    public static int maxSumInConfiguration(int [] arr){
        int n= arr.length;
        int sum = 0;
        for(int i: arr){
            sum+=i;
        }
        System.out.println("Total sum : "+sum);
        int curVal =0;
        for(int i=0;i<n;i++){
            curVal += (i*arr[i]);
        }
        System.out.println("Current value : "+curVal);

        int result = curVal;
        for(int i=1;i<n;i++){
            System.out.println("loop "+i+ " ");
            System.out.println(curVal+" - ("+sum+" - "+arr[i-1]+") + "+arr[i-1]+" x "+ 3);
            int nextValue = curVal - (sum-arr[i-1]) + arr[i-1] * (n-1);

            curVal = nextValue;
            System.out.println("next value: "+nextValue);
            result = Math.max(nextValue, result);
//            System.out.println("result after iteration : "+result);
        }

        return result;


    }


    public static void sortedSubsequenceOfSize3(int [] arr){
        int n = arr.length;
        int max = n - 1;
        int min = 0;
        int i;
        int[] smaller = new int[n];

        smaller[0] = -1;
        for (i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;
        }
        System.out.println("smaller array:");
        for(int j:smaller){
            System.out.print(i+" ");
        }

        int[] greater = new int[n];

        greater[n - 1] = -1;
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;
        }
        System.out.println();
        System.out.println("greater array");
        for(int j:greater){
            System.out.print(i+" ");
        }
        System.out.println();
        for (i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                System.out.print(
                        arr[smaller[i]] + " " + arr[i]
                                + " " + arr[greater[i]]);
                return;
            }
        }

        // If we reach number, then there
        // are no such 3 numbers
        System.out.println("No such triplet found");
        return;
        
//        int ans [] = new int[3];
//
//        int seq = 1;
//
//        int min_num = arr[0];
//
//        int max_seq = Integer.MIN_VALUE;
//
//        int store_min = min_num;
//
//        for(int i=1;i<arr.length;i++){
//            if(arr[i] == min_num){
//                continue;
//            } else if (arr[i] < min_num) {
//                min_num = arr[i];
//                continue;
//            }
//            else if (arr[i] < max_seq){
//                max_seq = arr[i];
//                store_min = min_num;
//            }
//            else if(arr[i]>max_seq){
//                seq++;
//                if(seq == 3){
//                    System.out.println("Triplet: " + store_min +
//                            ", " + max_seq + ", " + arr[i]);
//                    return;
////                    ans[0] = store_min;
////                    ans[1] = max_seq;
////                    ans[2] = arr[i];
////                    break;
//                }
//            }
//            max_seq = arr[i];
//        }
//
//        for(int i:ans){
//            System.out.print(i+ " ");
//        }
//        System.out.println();
////        return ans;

    }

    public static ArrayList<Integer> duplicates(int arr[]){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        System.out.println("before");
        for(int i:arr){
            System.out.print(i+ " ");
        }
        System.out.println();

        for(int i=0;i<n;i++){
            System.out.println("ops: "+arr[i]%n);
            System.out.println("before array val : "+arr[arr[i]%n]);
            arr[arr[i]%n] += n;
            System.out.println("after array val : "+arr[arr[i]%n]);

        }

        System.out.println("after");
        for(int i:arr){
            System.out.print(i+ " ");
        }
        System.out.println();

        for(int i=0;i<n;i++){
            if(arr[i]/n >1){
                ans.add(Integer.valueOf(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int n = 1020;
//        System.out.println(convertToFive(n));
//        int [] arr = {2,6,12,-14,7};
//        System.out.println(find3rdLargest(arr));
//        List<Integer> list = maxAnd2ndMax(arr);
//        System.out.println(list);
//        System.out.println(minDistance(arr,6,7));
//        for(int i: reverseArrray(arr)){
//            System.out.print(i+" ");
//        }
//        System.out.println();

//        int [] arr1 = {2,3,7,11,2,7,13,17};
//        int [] arr2 = {8,3,1,2};
//
//        int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
//        int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };

//        System.out.println(maxSumPath2Arrays(ar1, ar2));
//
//        List<Integer> list = Arrays.stream(arr1)
//                .boxed()
//                .collect(Collectors.toList());
//
//        System.out.println("before");
//        System.out.println(list);
//        removeDuplicates(list);
//        System.out.println("after");
//        System.out.println(list);

//        System.out.println(removeDupFromSmallPrimeNoArray(arr1));

//        System.out.println(maxSumInConfiguration(arr2));

//        int arr[] = {12, 11, 10, 5, 6, 2, 30};
//        sortedSubsequenceOfSize3(arr);

        int [] arr1 = {1, 2, 3, 1, 3};

        System.out.println(duplicates(arr1));

    }
}
