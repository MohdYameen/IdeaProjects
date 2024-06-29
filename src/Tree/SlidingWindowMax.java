package Tree;

public class SlidingWindowMax {

    //input is an array and maxsum, output will be max length with sum less tha maxSum
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

//    public static void generateAllSubArrays(int [] arr){
//        for(int i=0;i< arr.length;i++){
//            for(int j=i; j<arr.length; j++){
//                for(int k=i;k <=j; k++){
//                    System.out.print(arr[k]+", ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//    }

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

    public static void main(String[] args) {
        //TODO fix this code
//        int [] arr = {-1,3,5,1,7,10};
        int [] arr = {6,2,3,4,7,2,1,7,1};
        int maxSum = 14;
        int k =4;
        //generateAllSubArrays(arr);
        //System.out.println(maxLength(arr, maxSum));
        //sumEachWindow(arr, 3);
        System.out.println(maximumPointsFromCards(arr, k));



    }
}
