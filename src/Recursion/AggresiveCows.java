package Recursion;

import java.util.Arrays;

public class AggresiveCows {

    static boolean isPossibleToPlaceCows(int [] stalls, int cows, int minDistance){
        int lastCow = stalls[0];
        cows--;
        for(int i=1;i<stalls.length;i++){
            if(stalls[i] - lastCow >= minDistance){
                lastCow = stalls[i];
                cows--;
            }
            if(cows == 0){
                return true;
            }
        }
        return false;
    }

    static int maxDistanceAmongCows(int [] stalls, int cows){
        Arrays.sort(stalls);
        int solution = 0;

        int left = 0;
        int right = stalls[stalls.length-1] - stalls[0];

        while(left <= right){
            int mid = (left+right)/2;
            if(isPossibleToPlaceCows(stalls, cows, mid)){
                solution = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int [] stalls = {0,15,10,20,25,2};
        int cows = 4;
        System.out.println(maxDistanceAmongCows(stalls, cows));
    }
}
