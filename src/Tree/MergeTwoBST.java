package Tree;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoBST {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    public static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if (root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void getInOrder(Node root, ArrayList<Integer> arr){
        if (root == null) return;
        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end){
        if(start > end) return null;
        int mid = (start+end) /2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2){
        //step 1 : inroder root1
        ArrayList<Integer> arr =new ArrayList<>();
        getInOrder(root1, arr);

        //step 2: inroder root2
        getInOrder(root2, arr);

        // sort the combined array
        Collections.sort(arr);
//        for(Integer i: arr){
//            System.out.print(i+" ");
//        }

        // create balanced BST for sortedArrayList
        return createBST(arr, 0, arr.size()-1);
    }

    public static void main(String[] args) {
        
         Node root = new  Node(50);
        root.left = new  Node(30);
        root.left.left = new  Node(5);
        root.left.right = new  Node(20);

        root.right = new  Node(60);
        root.right.right = new  Node(70);
        root.right.left = new  Node(45);
        root.right.right.left = new  Node(65);
        root.right.right.right = new  Node(80);
        
        
        Node bst1 = new Node(2);
        bst1.left = new Node(1);
        bst1.right = new Node(4);

        Node bst2 = new Node(9);
        bst2.left = new Node(3);
        bst2.right = new Node(12);

        Node combineBST = mergeBST(bst1, bst2);

        

        System.out.print("In Order : ");
        inOrder(combineBST);
        System.out.println();
        System.out.print("Pre Order : ");
        preOrder(combineBST);


    }
}
