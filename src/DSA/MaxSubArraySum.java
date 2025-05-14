package DSA;

public class MaxSubArraySum {
    public static int maxSubArraySum(int []a){
        int max_sum = Integer.MIN_VALUE;
        int current_sum;
        for (int i =0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                current_sum =0;
                for (int k=i;k<=j;k++){
                    current_sum+=a[k];
                }
                if(current_sum > max_sum){
                    max_sum = current_sum;
                }
            }
        }
        return max_sum;
    }

    //using prefix array
    public static int [] prefixArray(int []a){
        int []prefix = new int[a.length];
        prefix[0]=a[0];
        for (int i=1;i<a.length;i++){
            prefix[i]=prefix[i-1]+a[i];
        }
        return prefix;
    }

    public static int maxSubArraySumUsingPrefix(int []a){
        int [] prefix = prefixArray(a);
        int currSum;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                currSum = i ==0 ? prefix[j] : prefix[j] - prefix[i-1];

                if (maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        //System.out.println("Max Sum of Sub Array using Prefix: "+maxSum);
        return maxSum;
    }

    public static int kadanesAlgo(int [] a){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int j : a) {
            currSum += j;
            System.out.println("value in array : "+j);
            System.out.println("Curr sum : "+currSum);
            if (currSum < 0) {
                currSum = 0;
                System.out.println("Curr sum reset to : "+currSum);
            }
            maxSum = Math.max(maxSum, currSum);
            System.out.println("Max sum : "+maxSum);
            System.out.println("*********************************");
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int [] arr = {1,-2,6,-1,3};
        int [] numbers = {-2,-3,4,-1,-2,1,5,-3};
//        System.out.println("Max Sub Array Sum: "+maxSubArraySum(arr));

//        for (int i =0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//
//        int []prefixArray = prefixArray(arr);
//        for (int i =0;i<prefixArray.length;i++){
//            System.out.print(prefixArray[i]+" ");
//        }

//        System.out.println();
//        System.out.println("Max Sum of Sub Array using Prefix: "+maxSubArraySumUsingPrefix(arr));



        System.out.println("Max Sum of Sub Array using Kadane's Algorithm: "+kadanesAlgo(arr));

    }
}
