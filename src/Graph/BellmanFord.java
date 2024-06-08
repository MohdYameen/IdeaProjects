package Graph;

import java.util.ArrayList;

public class BellmanFord {

    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void bellmanFord(ArrayList<Edge> [] graph, int src){
        int dist [] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        // algorithm  O(V*E)
        for(int i=0; i<V-1; i++){
            // O(E) => both j and K loop complexity
           for(int j=0; j<graph.length; j++){
               for(int k=0; k<graph[j].size(); k++){
                   Edge e = graph[j].get(k);
                   //u=e.src, v=e.dest and weight=e.wt
                   int u = e.src;
                   int v = e.dest;
                   int wt = e.wt;
                   // relaxation
                   if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                       dist[v] = dist[u] + wt;
                   }
               }
           }
        }

        //print
        for(int i:dist){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V){
        int dist [] = new int[V];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        // algorithm  O(V*E)
        for(int i=0; i<V-1; i++){
            // O(E) => both j and K loop complexity
            for(int j=0; j<graph.size(); j++){
                Edge e = graph.get(j);
                //u=e.src, v=e.dest and weight=e.wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                // relaxation
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        //print
        for(int i:dist){
            System.out.print(i+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 2,-4));

        graph[2].add(new Edge(2, 3,2));

        graph[3].add(new Edge(3, 4,4));

        graph[4].add(new Edge(4, 1,-1));

        bellmanFord(graph, 0);

        ArrayList<Edge> newGraph = new ArrayList<>();

        newGraph.add(new Edge(0, 1,2));
        newGraph.add(new Edge(0, 2,4));

        newGraph.add(new Edge(1, 2,-4));

        newGraph.add(new Edge(2, 3,2));

        newGraph.add(new Edge(3, 4,4));

        newGraph.add(new Edge(4, 1,-1));

        bellmanFord2(newGraph, 0, 5);
    }
}
