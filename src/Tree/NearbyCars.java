package Tree;

import java.util.PriorityQueue;

public class NearbyCars {

    static class Points implements Comparable<Points> {
        int x;
        int y;
        int dist;
        int index;

        Points(int x, int y, int dist, int index){
            this.x=x;
            this.y=y;
            this.dist=dist;
            this.index=index;
        }

        @Override
        public int compareTo(Points p2) {
            return this.dist - p2.dist; // acsending order
        }
    }

    public static void main(String[] args) {
        int [][] points = {{3,3},{5,-1},{-2,4}};
        int k =2;

        PriorityQueue<Points> pq = new PriorityQueue<>();

        for (int i=0; i<points.length;i++){
            int distSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Points(points[i][0], points[i][0], distSq, i));
        }

        for (int i=0; i<k; i++){
            System.out.println("Car"+pq.remove().index);
        }
    }

}
