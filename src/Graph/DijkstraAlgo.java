package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo{
    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n=n;
            this.path=path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; //small value comes first, path based sorting
        }
    }


    public static void dijkstra(ArrayList<Edge> [] graph, int src){
        int [] dist = new int[graph.length];
        dist[src] = 0;
        for(int i=0; i< graph.length; i++){
            if(i != src) dist[i] = Integer.MAX_VALUE;
        }

        boolean vis [] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // add src to src distance, i.e 0.

        //loop for BFS
        while(!pq.isEmpty()){
            Pair curr =  pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                //neighbors
                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){ //update distance from src to v
                        dist[v] = dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }

        }

        //print all shortest paths.
        for(int i:dist){
            System.out.println(i + " ");
        }


    }

    public static void main(String[] args) {
        ArrayList<Edge> [] graph = new ArrayList[6];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 2,1));
        graph[1].add(new Edge(1, 3,7));

        graph[2].add(new Edge(2, 4,3));

        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));

        dijkstra(graph, 0);

    }
}
