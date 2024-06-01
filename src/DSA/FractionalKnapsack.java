package DSA;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int [] val = {60,100,120};
        int [] weight = {10,20,30};
        int capacity = 50;

        double [][] ratio = new double[val.length][2];

        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=(double) val[i]/weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalValue = 0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalValue+=val[idx];
                capacity -= weight[idx];
            } else{
                finalValue += ratio[i][1]*capacity;
                //capacityRemaining = 0;
                break;
            }
        }
        System.out.println(finalValue);
    }
}
