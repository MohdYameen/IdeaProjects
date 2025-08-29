package Tree;

public class SlidingWindowMax {

    //input is an array and maxsum, output will be max length with sum less than equals maxSum
    public static int maxLength(int [] arr, int maxSum){
        //Brute Force
//        int maxLength = 0;
//        for(int i=0;i< arr.length;i++){
//            int sum =0;
//            for(int j=i; j<arr.length; j++) {
//                sum += arr[j];
//                if (sum <= maxSum) {
//                    maxLength = Math.max(maxLength, j - i + 1);
//                } else if (sum > maxSum) {
//                    break;
//                }
//            }
//        }
//        return maxLength;

        //optimized
        int l=0, r=0, sum=0, maxLength=0;
        while(r<arr.length){
            sum+=arr[r];
            if(sum > maxSum){
                sum -= arr[l];
                l++;
            }
            if(sum <= maxSum){
                maxLength = Math.max(maxLength, r-l+1);
            }
            r++;
        }

        return maxLength;
    }

    public static int [] sumEachWindow(int []arr, int n){
        int [] sol = new int[arr.length-n+1];
        for(int i=0; i<sol.length; i++){
            for(int j=i; j<i+n; j++){
                sol[i] += arr[j];
            }
        }
        for(int i:sol){
            System.out.print(i+" ");
        }
        return sol;
    }

    public static void generateAllSubArrays(int [] arr){
        int count =0;
        for(int i=0;i< arr.length;i++){
            for(int j=i; j<arr.length; j++){
                for(int k=i;k <=j; k++){
                    System.out.print(arr[k]+", ");
                }
                System.out.println();
                count++;
            }
            System.out.println();
        }

        System.out.println("total sub arrays : "+count);
    }

    public static int maximumPointsFromCards(int [] arr, int k){
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        for(int i=0;i<k;i++){
            leftSum += arr[i];
        }

        maxSum = leftSum;
        //System.out.println("MAx sum only left part: "+maxSum);

        int rightIndex = arr.length-1;
        for(int i= k-1; i>=0; i--){
            leftSum -= arr[i];
            rightSum += arr[rightIndex];
            rightIndex--;
            maxSum = Math.max(maxSum, leftSum+rightSum);
            //System.out.println("Max sum after each iteration of removing from left and including from right : "+(leftSum+rightSum));

        }
        return maxSum;
    }

    //int [] arr = {6,2,3,4,7,2,1,7,1};
    public static void findSubarrayWithGivenSum(int [] arr, int target){
        int sum=0, start=0;
        int maxLen = 0;

        for(int end = 0; end<arr.length; end++){

            ///  keep increasing the length of window
            sum+=arr[end];
//            System.out.println("Print sum from start "+ start+" to  end "+end+" : "+sum);

            ///  shrink the window size
            while(sum > target && start < end){
                sum-=arr[start];
                start++;
            }

            if(sum == target){
                System.out.println("array starts from "+ start+" and ends at "+end);
                maxLen = Math.max(maxLen, end-start);

            }
        }
        System.out.println("Longest array length with target is : "+maxLen);

//        System.out.println("Subaaray not found.");

    }

    public static void main(String[] args) {
        //TODO fix this code
//        int [] arr = {-1,3,5,1,7,10};
        int [] arr = {6,2,3,4,7,2,1,7,1};
        int maxSum = 14;
        int k =4;
//        generateAllSubArrays(arr);
        //System.out.println(maxLength(arr, maxSum));
//        sumEachWindow(arr, 3);
        //System.out.println(maximumPointsFromCards(arr, k));

        findSubarrayWithGivenSum(arr, 14);



    }
}
