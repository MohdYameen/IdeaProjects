package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    static class Edge1{
        int src, dest, weight;
        public Edge1(int src, int dest, int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }

    public static void calculateInDegree(ArrayList<Edge1> [] graph, int [] inDegree){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge1 e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }

    public static void topologicalSortBFS(ArrayList<Edge1> [] graph){
        int [] inDegree = new int[graph.length];
        calculateInDegree(graph, inDegree);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+ " ");

            for(int i=0; i<graph[curr].size();i++){
                Edge1 e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest] == 0) q.add(e.dest);
            }
        }
        System.out.println();

    }



    public static void topologicalSortDFS(ArrayList<Edge1> [] graph){
        boolean [] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<graph.length; i++){
            if(!visited[i]){
                topSortUtil(graph, i, visited, s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge1> [] graph, int curr, boolean [] visited, Stack<Integer> s){
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge1 e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSortUtil(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge1>[] graph = new ArrayList[V];

        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge1(2,3,1));

        graph[3].add(new Edge1(3,1,1));

        graph[4].add(new Edge1(4,0,1));
        graph[4].add(new Edge1(4,1,1));

        graph[5].add(new Edge1(5,0,1));
        graph[5].add(new Edge1(5,2,1));

//        System.out.print("Neighbors of Vertex 4 : ");
//        for(int i=0; i<graph[4].size(); i++){
//            System.out.print(graph[4].get(i).dest+" ");
//        }


        System.out.println();
        System.out.print("Topological Sort BFS: ");
        //topologicalSortDFS(graph);
        topologicalSortBFS(graph);



    }
}
