package Graph;

import java.util.*;

public class GraphClone {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while(!q.isEmpty()){

            Node h = q.remove();

            for(Node neighbor: h.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                map.get(h).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    // ChatGPT
//    public static void bfs(Node start, Set<Node> visited) {
//        Queue<Node> queue = new LinkedList<>();  // Initialize the queue with the start node
//        queue.add(start);
//        visited.add(start);
//
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();  // Dequeue a node from the front of the queue
//            System.out.println(node.val);  // Print the node's value
//
//            // Enqueue all adjacent nodes that have not been visited
//            for (Node neighbor : node.neighbors) {
//                if (!visited.contains(neighbor)) {
//                    visited.add(neighbor);
//                    queue.add(neighbor);
//                }
//            }
//        }
//    }
//
//    public static void printAllNodes(List<Node> nodes) {
//        Set<Node> visited = new HashSet<>();  // To keep track of visited nodes
//        for (Node node : nodes) {
//            if (!visited.contains(node)) {
//                bfs(node, visited);
//            }
//        }
//    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        ArrayList<Node> ne1 = new ArrayList<>();
        ne1.add(n3);
        ne1.add(n2);

        ArrayList<Node> ne2 = new ArrayList<>();
        ne1.add(n1);
        ne1.add(n4);
        ArrayList<Node> ne3 = new ArrayList<>();
        ne1.add(n1);
        ne1.add(n4);
        ArrayList<Node> ne4 = new ArrayList<>();
        ne1.add(n3);
        ne1.add(n2);


        Node head = n1;
        Node n2new = cloneGraph(head);


        printAllNodes(n1.neighbors);
        System.out.println("ZCV");
        //printAllNodes(n2new.neighbors);

    }
}
