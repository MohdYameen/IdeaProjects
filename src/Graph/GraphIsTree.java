package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphIsTree {

    public static class Edge{
        int src, dest, weight;
        public Edge(int src, int dest, int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }

    public static void BFS(ArrayList<Edge> [] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+ " ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> [] graph, int curr, boolean [] visited){
        System.out.print(curr + " ");
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                DFS(graph, e.dest, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> [] graph, int src, int dest, boolean [] visited){
        if(src == dest) return true;
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 8;
        ArrayList<Edge> [] graph = new ArrayList[V];

        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(4,4,1));
        graph[5].add(new Edge(4,6,1));

        graph[6].add(new Edge(6,5,1));

        graph[7].add(new Edge(7,7,1));

        /*
          1-----------3
         /            | \
        0             |   5------6
         \            | /
          2-----------4                     7

         */

        // 2's neighbours

        System.out.print("Neighbors of Vertex 4 : ");
        for(int i=0; i<graph[4].size(); i++){
            System.out.print(graph[4].get(i).dest+" ");
        }

        System.out.println();
        System.out.print("BFS : ");
        BFS(graph);

        System.out.println();
        System.out.print("DFS : ");
        DFS(graph, 0, new boolean[V]);

        System.out.println();
        System.out.print("Has path between : ");
        System.out.print(hasPath(graph, 0, 7, new boolean[V]));
        System.out.println();
    }
}
