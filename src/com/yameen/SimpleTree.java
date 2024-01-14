package com.yameen;

public class SimpleTree {

    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
        public Node root;
       public void createTree(){
           /* Node first = new Node(6);
            Node second = new Node(7);
            Node third = new Node(3);
            Node forth = new Node(4);
            Node fifth = new Node(5);

            root = first;
            first.left = second;
            first.right = third;
            second.left = forth;
            second.right = fifth;  */

           root = new Node(5);
           root.left = new Node(4);
           root.right = new Node(8);
           root.left.left = new Node(1);
           root.left.right = new Node(3);


            }

    void inOrder(Node root) {
        //System.out.println("Inorder Traversal : ");
        if (root != null) {
            inOrder(root.left);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }
    void preOrder(Node root){
           if(root != null){
               System.out.print(" " + root.data);
               preOrder(root.left);
               preOrder(root.right);
           }
    }
    void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" " + root.data);
        }
    }


    public static void main(String ... args){
           SimpleTree stree = new SimpleTree();
           stree.createTree();
           stree.inOrder(stree.root);
        System.out.println();
            stree.preOrder(stree.root);
        System.out.println();
        stree.postOrder(stree.root);

           }

}
