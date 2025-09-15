package DSA;

import java.util.ArrayList;

public class IndianCurrency {

    //denominations: 1,2,5,10,20,50,100,200,500,2000
    // sort descending order
    //[2000,500,200,100,50,20,10,5,2,1]
    public static void main(String[] args) {
        int [] dom = {2000,500,200,100,50,20,10,5,2,1};
        int amount = 1090;
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // greedy algo
        for(int i =0;i<dom.length;i++){
            if(dom[i] <= amount){
                while (dom[i] <= amount){
                    count++;
                    ans.add(dom[i]);
                    amount-=dom[i];
                }
            }
        }
        System.out.println(count);
        System.out.println(ans);
//
//
//        for (int i =0;i<ans.size();i++){
//            System.out.print(ans.get(i)+" ");
//        }
//        int n =6;
//        for(int i=0;i<n;i++){
//            int space = n-i-1;
//            int hash = i;
//            while(space > 0){
//                System.out.print(" ");
//                space--;
//            }
//            while(hash>=0){
//                System.out.print("#");
//                hash--;
//            }
//            for(int j=i;j>=0;j--){
//                System.out.print("#");
//            }
//
//
//            System.out.println();
//        }


    }
}
