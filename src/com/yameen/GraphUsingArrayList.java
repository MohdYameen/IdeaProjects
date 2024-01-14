package com.yameen;

import java.util.ArrayList;

public class GraphUsingArrayList {
    int noNodes;
    ArrayList<ArrayList<Integer>> graph;
    GraphUsingArrayList(int nodes){
        noNodes = nodes;
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<noNodes;i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    void addEdge(int v, int u){
        graph.get(v).add(u);
        graph.get(u).add(v);
    }


    void show(){
        for(int i =0;i<noNodes; i++){
            System.out.print("Node "+i +" ");
            for(int x : graph.get(i)){
                System.out.print(" - > " +x);

            }
            System.out.println();
        }

    }



    public static void main(String ... args){
        GraphUsingArrayList gr = new GraphUsingArrayList(6);
        gr.addEdge(1,2);
        gr.addEdge(1,3);
        gr.addEdge(1,4);
        gr.addEdge(1,5);
        gr.addEdge(3,4);
        gr.addEdge(4,2);
        gr.show();

    }
}
