package com.yameen;

public class Practice {
/*
    //Linkedlist
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node head;
    void add(int data){
        Node toAdd = new Node(data);
        if(head == null){
            head = toAdd;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next= toAdd;
        }

    }
    void show(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
*/

    /*
    //Tree
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left = right = null;
        }
}
    void add(Node node, int data){
        if(data < node.data){
            if(node.left!=null){
                add(node.left, data);
            }
            else{
                node.left = new Node(data);
            }
        }
        else if( data >= node.data){
            if(node.right != null){
                add(node.right, data);
            }
            else{
                node.right = new Node(data);
            }

        }
    }

    void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.data+ " ");
            inOrder(node.right);
        }
    }
    void preOrde(Node node){
        if(node!=null){
            System.out.print(node.data + " ");
            preOrde(node.left);
            preOrde(node.right);

        }

    }

*/



    public static void main(String ... args){
     /*   Practice mylist = new Practice();
        mylist.add(5);
        mylist.add(8);
        mylist.show();   linkedlist */

/*
        Practice mytree = new Practice();
        Node root = new Node(10);
        mytree.add(root, 5);
        mytree.add(root, 6);
        mytree.add(root, 52);
        mytree.add(root, 12);
        mytree.inOrder(root);
        mytree.preOrde(root);    Tree */


        /* ***************String to Integer and vice versa*************************
        String s = "100";
        int i = 200;
        String s1 = String.valueOf(i);
        String s2 = Integer.toString(i);

        int i1 = Integer.parseInt(s);
        Integer i2 = Integer.valueOf(s);

        System.out.println("i : "+i);
        System.out.println("s : "+s);
        System.out.println("i1 : "+(i1+5));
        System.out.println("i2 : "+(i2+7));
        System.out.println("s1 : "+(s1+4));

        System.out.println("s2 : "+(s2+6));

    */
        /*
    double f =  0.1f;
    if(f==0.1)
        System.out.println("Yes");
    else
        System.out.println("No");
        */
        /*
        int x = 22;
        float pie = 3.1415909090f;
        float a = x*x*pie;
        System.out.println(a);
        System.out.printf("%.3f",a);   // %.2f gives #.## output,  %.3f -> #.###

         */

        /*
        Kalgudi programming question

        int L =10;
        int R = 12;
        int result = 0;
        ArrayList<String> ar = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        for(int i =L;i<=R;i++){

            if(i%2==0) {
                String s = Integer.toBinaryString(i);
                ar.add(s);
            }
        }
        for(int i =0;i<ar.size();i++){
            int count = 0;
            for(int j =0;j<ar.get(i).length();j++){
                char c = ar.get(i).charAt(j);
                if(c=='1'){
                    count++;
                }
            }
            ar2.add(count);
        }
        for(int i =0;i<ar2.size();i++){
            int flag = 0;
            int temp = ar2.get(i);
            int m =temp/2;
            if(temp == 0 || temp == 1){
                flag = 1;
            }
            else{
                for(int j =2;j<=m;j++){
                    if(temp%j ==2){
                        flag =1;
                        break;
                    }
                }
            }
            if(flag == 0)
                result++;


        }

        System.out.println(result);

        String s = "([][]{})";
        Stack<Character> stck = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c=='('){
                stck.push(c);
            }
            else if(c == ')'){
                if(stck.size() == 0){
                    System.out.println(false);
                    return;
                }
                else if(c == '{' || c == '['){
                    System.out.println(false);
                    return;
                }
                else{
                    stck.pop();
                }
            }
            else if(c == '}'){
                if(stck.size() == 0){
                    System.out.println(false);
                    return;
                }
                else if(c == '(' || c == '['){
                    System.out.println(false);
                    return;
                }
                else{
                    stck.pop();
                }

            }
            else if(c == ']'){
                if(stck.size() == 0){
                    System.out.println(false);
                    return;
                }
                else if(c == '{' || c == '('){
                    System.out.println(false);
                    return;
                }
                else{
                    stck.pop();
                }

            }



        }
        if(stck.size() == 0)
            System.out.println(true);
        else
            System.out.println(false);



         */
        Mutable mt = new Mutable(5);
        System.out.println(mt.getA());
        mt.setA(34);
        System.out.println(mt.getA());
        Immutable imt = new Immutable(67);
        System.out.println(imt.getA());


    }
    static class Mutable{
        private int a;
        Mutable(int a){
            this.a=a;
        }
        public int getA(){
            return a;
        }
        public void setA(int a){
            this.a=a;
        }

    }
    static class Immutable{
        private final int a;
        Immutable(int a ){
            this.a=a;
        }
        public int getA(){
            return a;
        }
        //public void setA(int a){  cannot have setter, bcz variable is final;
         //   this.a=a;
        //}
    }
}
