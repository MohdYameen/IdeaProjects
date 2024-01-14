package com.yameen;

public class Graph {
    class Edge{
        int src, dest;
    }
    int vertices, edges;
    Edge e [];

    Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        e = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            e[i] = new Edge();
        }
    }

    public static void main(String ... args){
        int noVertices = 5;
        int noEdges = 8;
        Graph gr = new Graph(noVertices, noEdges);
        gr.e[0].src = 1;
        gr.e[0].dest = 2;

        gr.e[1].src = 1;
        gr.e[1].dest = 3;

        gr.e[2].src = 2;
        gr.e[2].dest = 4;

        gr.e[3].src = 2;
        gr.e[3].dest = 5;

        gr.e[4].src = 3;
        gr.e[4].dest = 5;

        gr.e[5].src = 5;
        gr.e[5].dest = 4;

        gr.e[6].src = 4;
        gr.e[6].dest = 5;

        gr.e[7].src = 4;
        gr.e[7].dest =3;

        for(int i =0;i<noEdges; i++){
            System.out.print(gr.e[i].src +" --> "+gr.e[i].dest);
            System.out.println();
        }

    }

}
