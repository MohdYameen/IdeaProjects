package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgo {

    static class Edge implements Comparable<Edge>{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    //disjoint part

    static int n = 4;
    static int [] par = new int[n];
    static int [] rank = new int[n];

    public static void init(){
        for(int i=0; i<n; i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(x == par[x]) return x;
        return par[x]=find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            rank[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        }else {
            par[parB] = parA;
        }
    }

    public static int kruskalsMST(ArrayList<Edge> edges, int V){ //O(V) + ElogE
        init();
        Collections.sort(edges);
        int finalCost = 0;
        for(int i=0; i<V-1; i++){
            Edge e =edges.get(i);
            //cycle
            int parA = find(e.src); //a
            int parB = find(e.dest); //b

            if(parA != parB){
                union(e.src, e.dest);
                finalCost += e.wt;
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));


        System.out.println(kruskalsMST(edges, 4));

    }
}
