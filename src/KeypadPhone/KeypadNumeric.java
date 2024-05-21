package KeypadPhone;

import java.util.ArrayList;
import java.util.List;

public class KeypadNumeric {

    static int getCount(int n){
        if(n==1) return 10;

        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l0 = new ArrayList<>();
        l0.add(0);
        l0.add(8);
        l.add(l0);

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        l.add(l1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(5);
        l.add(l2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(3);
        l3.add(6);
        l3.add(2);
        l.add(l3);

        List<Integer> l4 = new ArrayList<>();
        l4.add(1);
        l4.add(4);
        l4.add(5);
        l4.add(7);
        l.add(l4);

        List<Integer> l5 = new ArrayList<>();
        l5.add(2);
        l5.add(4);
        l5.add(5);
        l5.add(6);
        l5.add(8);
        l.add(l5);

        List<Integer> l6 = new ArrayList<>();
        l6.add(3);
        l6.add(5);
        l6.add(6);
        l6.add(9);
        l.add(l6);

        List<Integer> l7 = new ArrayList<>();
        l7.add(4);
        l7.add(7);
        l7.add(8);
        l.add(l7);

        List<Integer> l8 = new ArrayList<>();
        l8.add(5);
        l8.add(7);
        l8.add(8);
        l8.add(9);
        l8.add(0);
        l.add(l8);

        List<Integer> l9 = new ArrayList<>();
        l9.add(6);
        l9.add(8);
        l9.add(9);
        l.add(l9);

        int [] count = new int[10];
        for(int i=0; i<10; i++){
            count[i]=1;
        }

        for(int i=2; i<=n; i++){
            int [] countTemp = new int[10];

            for(int j=0; j<10; j++){

                for(int x: l.get(j)){
                    countTemp[x]+=count[j];
                }
            }

            for(int j=0; j<10; j++){
                count[j]=countTemp[j];
            }
        }

        int total = 0;
        for(int i=0; i<10; i++){
            total+=count[i];
        }
        return total;



//Print the list of list
//        for(int i=0;i<l.size();i++){
//            System.out.print(i+": ");
//            for(int j=0;j<l.get(i).size();j++){
//                System.out.print(l.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }






    }

    public static void main(String[] args) {
        System.out.println(getCount(3));

    }
}
