package DSA;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args) {

//        int [] start = {1,3,5,0,8,5,};
//        int [] end = {2,4,6,7,9,9};
//        //sorting if end time not sorted
//
//        int activities [][] = new int[start.length][3];
//        for(int i =0;i<start.length;i++){
//            activities[i][0] = i;
//            activities[i][1] = start[i];
//            activities[i][2] = end[i];
//        }
//        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
//        ArrayList<Integer> ans = new ArrayList<>();
//        int maxAct = 1;
//        ans.add(activities[0][0]);
//        int lastEnd = activities[0][2];
//
//        for(int i=1;i<start.length;i++){
//            if(activities[i][1] >= lastEnd){
//                maxAct++;
//                ans.add(activities[i][0]);
//                lastEnd = activities[i][2];
//            }
//        }
//        System.out.println("Max Activities: "+maxAct);
//        for(int i=0; i<ans.size();i++){
//            System.out.print("Activity no: "+ans.get(i)+ " ");
//        }

        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int lastEnd = pairs[0][1];
        for(int i = 1;i<pairs.length;i++){
            if(pairs[i][0] > lastEnd){
                chainLength++;
                lastEnd = pairs[i][1];
            }
        }
        System.out.println("Chain length: "+ chainLength);




    }
}
