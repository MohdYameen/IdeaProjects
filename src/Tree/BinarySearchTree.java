package Tree;

public class BinarySearchTree {

    static class Node{
        int data;
        Node left;
        Node right;
         Node(int data){
             this.data=data;
         }
    }

    static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if (root.data > val){
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static boolean search(Node root, int key){
        if(root == null) return false;
        if(root.data == key) return true;
        if(root.data > key) return search(root.left, key);
        else return search(root.right, key);

    }

    static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        } else if( root.data < val){
            root.right = delete(root.right, val);
        } else{
            //case 1
            if(root.left == null && root.right == null) return null;

            //single child
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            //case3: both child exist
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values [] = {8,5,3,1,4,6,10,11,12};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        inOrder(root);
        delete(root,10);
        System.out.println();
        inOrder(root);


    }
}
