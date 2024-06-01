package Tree;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static void main(String[] args) {
        int [] ropes = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:ropes){
            pq.add(i);
        }

        int cost = 0;
        while(pq.size() > 1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min+min2;
            pq.add(min2+min);
        }
        System.out.println(cost);
    }
}
