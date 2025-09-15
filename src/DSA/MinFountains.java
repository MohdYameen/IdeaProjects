package DSA;

public class MinFountains {

    public static int minNoOfFountains(int [] arr){

        int n = arr.length-1;
        int maxRange [] = new int[n+1];
        int fountains = 0, currEnd = 0, nextEnd = 0;

        for(int i=0;i<=n;i++){
            int left = Math.max(0, i-arr[i]);
            int right = Math.min(n, i+arr[i]);
            maxRange[left] = Math.max(maxRange[left], right);
        }

        for(int i=0; i<n; i++){
            nextEnd = Math.max(nextEnd, maxRange[i]);
            if(i==currEnd){
                fountains++;
                currEnd=nextEnd;
            }
            if(currEnd>=n) return fountains;
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] a = {3,4,1,1,0,0};
        int [] b = {1,2,1,0,2,1,0,1};
        System.out.println(minNoOfFountains(a));
    }
}
