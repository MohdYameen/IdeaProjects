package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int [] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        //DFS
        public static void preOrder(Node root){
            if(root == null) return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            if(root == null) return;
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root == null) return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        //BFS
        public static void levelOrder(Node root){
            if(root ==  null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+ " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }

            }
        }

        public static int height(Node root){
            if(root == null) return 0;
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh)+1;
        }

        public static int countOfNodes(Node root){
            if(root == null) return 0;
            int leftCount = countOfNodes(root.left);
            int rightCount = countOfNodes(root.right);
            return leftCount+rightCount+1;

        }

        public static int sumOfNodes(Node root){
            if(root == null) return 0;
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum+rightSum+root.data;

        }

        public static int diameter1(Node root){
            if(root == null) return 0;

            int leftDiameter = diameter1(root.left);
            int rightDiameter = diameter1(root.right);
            int leftH = height(root.left);
            int rightH = height(root.right);

            return Math.max(Math.max(leftDiameter, rightDiameter), leftH+rightH+1);


        }


        static class Info{
            int diam;
            int height;
            public Info(int diam, int height){
                this.diam = diam;
                this.height =  height;
            }
        }

        public static Info diameter2(Node root){
            if(root == null) return new Info(0,0);

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);


            int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);
            int ht = Math.max(leftInfo.height, rightInfo.height) +1;
            return new Info(diameter, ht);
        }

        public static boolean isIdentical(Node root, Node subtree){
            if(root == null && subtree == null) return true;
            else if(root == null || subtree == null || root.data != subtree.data) return false;

            if(!isIdentical(root.left, subtree.left)) return false;
            if(!isIdentical(root.right, subtree.right)) return false;

            return true;

        }
        public static boolean isSubTree(Node root, Node subTree){
            if(root == null) return false;
            if(root.data == subTree.data){
                if(isIdentical(root, subTree)){
                    return true;
                }
            }
            return isSubTree(root.left, subTree) || isSubTree(root.right,subTree);
        }

        public static void topView(Node root){

            class InfoForTopView{
                Node node;
                int hd;
                 InfoForTopView(Node node, int hd){
                    this.node = node;
                    this.hd = hd;
                }
            }

            //for lever order
            Queue<InfoForTopView> q = new LinkedList<>();
            //for top view storage
            HashMap<Integer, Node> map = new HashMap<>();

            if(root == null) return;
            else q.add(new InfoForTopView(root, 0));
            int min =0;
            int max=0;

            while(!q.isEmpty()){
                InfoForTopView curr = q.remove();

//                if(curr == null){
//                    if(q.isEmpty()) break;
//                    else{
//                        q.add(null);
//                    }
//                }

                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null){
                    q.add(new InfoForTopView(curr.node.left, curr.hd-1));
                    min =  Math.min(curr.hd-1, min);
                }
                if(curr.node.right != null){
                    q.add(new InfoForTopView(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }

            }

            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data+ " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
//        int nodes [] = {1,2,4,8,9,-1,-1,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
////        int nodes [] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//        BinaryTree tree = new BinaryTree();
//        Node root = tree.buildTree(nodes);
//        System.out.print("PreOrder: ");
//        tree.preOrder(root);
//        System.out.println();
//        System.out.print("InOrder: ");
//        tree.inOrder(root);
//
//        System.out.println();
//        System.out.print("PostOrder: ");
//        tree.postOrder(root);
//        System.out.println();
//        System.out.println("LevelOrder: ");
//        tree.levelOrder(root);
//        System.out.println("Height "+tree.height(root));
////        System.out.println(tree.countOfNodes(root));
////        System.out.println(tree.sumOfNodes(root));
//        System.out.println("Diameter 1: "+tree.diameter1(root));
//        System.out.println("Diameter 2: "+tree.diameter2(root).diam);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
//
//        Node subtree = new Node(2);
//        subtree.left =  new Node(3);
//        subtree.right =  new Node(5);
//
//        System.out.println(isSubTree(root,subtree));
        BinaryTree.topView(root);




    }
}
