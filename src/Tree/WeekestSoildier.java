package Tree;

import java.util.PriorityQueue;

public class WeekestSoildier {

    static class Row implements Comparable<Row>{
        int soldiers;
        int index;
        public Row(int soldiers, int index){
            this.index=index;
            this.soldiers=soldiers;
        }


        @Override
        public int compareTo(Row o) {
            if(this.soldiers == o.soldiers) return this.index - o.index;
            else return this.soldiers - o.soldiers;
        }
    }

    public static void main(String[] args) {
        int [][] army  = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0; i< army.length; i++){
            int countSoldiers = 0;
            for(int j=0; j<army[0].length; j++ ){
                countSoldiers += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(countSoldiers, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("R"+pq.remove().index);
        }
    }
}
