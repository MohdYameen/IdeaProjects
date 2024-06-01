package Tree;

import java.util.ArrayList;

public class SortedArrayToBST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
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

    public static void getInOrder(Node root, ArrayList<Node> inorder){
        if (root == null) return;
        getInOrder(root.left, inorder);
        inorder.add(root);
        getInOrder(root.right, inorder);
    }


    public static Node createBalanceBST(int [] arr, int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalanceBST(arr, start, mid-1);
        root.right = createBalanceBST(arr, mid+1, end);
        return root;
    }

    public static Node createBST(ArrayList<Node> inorder, int start, int end ){
        if(start>end) return null;
        int mid = (start+end)/2;
        Node root = inorder.get(mid);
        root.left = createBST(inorder, start, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }

    public static Node balanceBST(Node root){
        ArrayList<Node> inorder = new ArrayList<>();
        getInOrder(root, inorder);
        return createBST(inorder, 0, inorder.size()-1);
    }


    public static void main(String[] args) {
//        int [] arr = {3,5,6,8,10,11,12};
//        Node root = createBalanceBST(arr, 0, arr.length-1);
//        System.out.print("Inroder : ");
//        inOrder(root);
//        System.out.println();
//        System.out.print("Preorder : ");
//        preOrder(root);

        Node tree2 = new Node(8);
        tree2.left = new Node(6);
        tree2.left.left = new Node(5);
        tree2.left.left.left = new Node(3);
        tree2.right = new Node(10);
        tree2.right.right = new Node(11);
        tree2.right.right.right = new Node(12);

        System.out.print("In Order : ");
        inOrder(tree2);
        System.out.println();
        System.out.print("Pre Order : ");
        preOrder(tree2);

        System.out.println();
        System.out.println("After Changes");
        System.out.print("In Order : ");
        inOrder(balanceBST(tree2)); // change the tree and print its inorder
        System.out.println();
        System.out.print("Pre Order : ");
        preOrder(tree2);

    }
}
