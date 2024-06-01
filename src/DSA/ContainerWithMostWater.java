package DSA;

import java.util.ArrayList;

public class ContainerWithMostWater {

    static int maxWaterUsing2Pointer(ArrayList<Integer> height){
        int lp=0;
        int rp=height.size()-1;
        int maxWater = 0;

        while(lp<rp){
            int currentWater = Math.min(height.get(lp), height.get(rp)) * (rp-lp);
            maxWater = Math.max(maxWater, currentWater);
            if(height.get(lp) < height.get(rp)) lp++;
            else rp--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        int maxWater = 0;
        //brute force
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int widht = j - i;
                int height1 = Math.min(height.get(i), height.get(j));
                int tempVal = widht * height1;
                if (tempVal > maxWater) {
                    maxWater = tempVal;
                }
            }
        }
        System.out.println(maxWater);
        System.out.println(maxWaterUsing2Pointer(height));
    }

}
