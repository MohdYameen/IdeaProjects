package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {

    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int v, cost;
        public Pair(int v, int cost){
            this.v=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void primsAlgoForMST(ArrayList<Edge>[] graph){
        boolean vis [] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int totalCost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                totalCost += curr.cost;

                //add neighbor

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("Minimum cost : "+totalCost);
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[4];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3,30));

        graph[1].add(new Edge(1, 0,10));
        graph[1].add(new Edge(1, 3,10));

        graph[2].add(new Edge(2, 0,15));
        graph[2].add(new Edge(2, 3,50));

        graph[3].add(new Edge(3, 0,30));
        graph[3].add(new Edge(3, 1,10));
        graph[3].add(new Edge(3, 2,50));

        primsAlgoForMST(graph);

    }
}
