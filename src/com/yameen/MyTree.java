package com.yameen;

public class MyTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    //Node root;
    void add(Node node, int data){
        if(data < node.data){
            if(node.left != null){
                add(node.left,data);
            }
            else{
                //System.out.println(" Inserted " + data + " to left of " + node.data);
                node.left = new Node(data);
            }
        }
        else if (data > node.data){
            if(node.right !=  null ){
                add(node.right,data);
            }
            else{
                //System.out.println(" Inserted " + data + " to right of " + node.data);
                node.right = new Node(data);
            }
        }
    }
    void inOrder(Node node){
        //System.out.println("Inorder Traversal : ");
        if(node != null){
            inOrder(node.left);
            System.out.print(" "+node.data);
            inOrder(node.right);
        }

    }
    void preOrder(Node node){
       // System.out.println("Pre Traversal : ");
        if(node != null){
            System.out.print(" "+node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    void postOrder(Node node){
       // System.out.println("Postorder Traversal : ");
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
           System.out.print(" "+node.data);
        }
    }

    public static void main(String ... args){
        MyTree tree = new MyTree();
        Node root = new Node(8);
        System.out.println("Binary Tree Example : ");
        System.out.println("Building Binary tree with root node "+root.data);

        tree.add(root, 4);
        tree.add(root, 12);
        tree.add(root,5);
        tree.add(root, 11);
        tree.add(root, 3);
        tree.add(root,45);
        System.out.println("Inorder Traversal : ");
        tree.inOrder(root);
        System.out.println();
        System.out.println("Preorder Traversal : ");
        tree.preOrder(root);
        System.out.println();
        System.out.println("Postorder Traversal : ");
        tree.postOrder(root);
        System.out.println();
    }
}