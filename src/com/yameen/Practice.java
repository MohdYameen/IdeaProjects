package com.yameen;

import java.rmi.Remote;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


class Animal{

    static void sound(){
        System.out.println("Animal Sound");
    }

    void eat(){
        System.out.println("Animal eat");
    }
}

class Dog extends Animal{
    static void sound(){
        System.out.println("Dog Sound");
    }

    void eat(){
        System.out.println("Dog eat");
    }
}

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



    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }

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


        //Reference type(LHS) : Object type(RHS)
//        Animal animal = new Dog();
//
//        animal.sound();     // animal sound : static methods are bound to the refernce type at the compile time not the object type;
//        animal.eat();       // dog eat : sound() in an overridden method in Dog, Java uses dynamic dispatch t determine the actual method to call at runtime based on object type.
//
//        Dog dog = new Dog();
//        dog.eat();
//        Dog.sound();
//
//        Animal an = new Animal();
//        an.sound();
//        an.eat();


        int [] arr = new int[100000];
        for(int i=0;i<100000;i++){
            arr[i]=i*2;
        }
//        System.out.println(Arrays.toString(arr));

        int target = 99690;
        for(int a : arr){
            if(a==target)
                System.out.println("Exist Using Linear Search");
        }

        System.out.println(binarySearch(arr, target)+" using binary");

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
//        Mutable mt = new Mutable(5);
//        System.out.println(mt.getA());
//        mt.setA(34);
//        System.out.println(mt.getA());
//        Immutable imt = new Immutable(67);
//        System.out.println(imt.getA());

        //filterstring with number
//        List<String > list = Arrays.asList("12qwerty","qwerty12", "7up", "abc");
//
//        List<String> newList = list.stream()
//                .filter(s-> Character.isDigit(s.charAt(0)))
//                .collect(Collectors.toList());


        List<String > list = Arrays.asList("qwerty","qwerty", "7up", "abc");
        Set<String> set = new HashSet<>();

        Set<String> newSet = list.stream().collect(Collectors.toSet());

        System.out.print("New Set : ");
        for(String s:newSet){
            System.out.print(s+" ");
        }

        System.out.println();
        List<String> newList = list.stream()
                .filter(s -> set.add(s))
                .collect(Collectors.toList());
        System.out.println("list: "+list.toString());

        System.out.println("newlist"+newList.toString());
        //
////
//        System.out.println(list);
//        System.out.println("sol");
//        System.out.println(newList);
//        HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap
//        map.put(null,"Mango");  //Put elements in Map
//        map.put(null,"Apple");
//        System.out.println("Iterating Hashmap...");
//        for(Map.Entry m : map.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
//        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        HashMap<String, Integer> hashMap = new HashMap<>();
//
//        String phoneRegex = "^\\+?[0-9]{1,3}[-\\s]?([6-9][0-9]{9})$";
//        String emailRegex = "[a-zA-Z0-9.-_+%]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
//
//        String email = "myameend@gmail.com";
//        String phone = "+917906653049";
//
//        if(email.matches(emailRegex))
//            System.out.println("Valid email : "+email);
//        else
//            System.out.println("Invalid email : "+email);
//
//        if(phone.matches(phoneRegex))
//            System.out.println("Valid Phone : "+phone);
//        else
//            System.out.println("Invalid phone : "+phone);
//
//        int n =12;
//        boolean isPrimary = true;
//
//        for(int i=2;i<n/2;i++){
//            if(n%i==0){
//                isPrimary = false;
//                break;
//            }
//        }
//        if(isPrimary) System.out.println("prime");
//        else System.out.println("not prime");
//
//        Dog dog = new Dog("Tommy");
//        dog.makeSound();

//        List<Boys> boysList = new ArrayList<>();
//        boysList.add(new Boys("Aman", 15));
//        boysList.add(new Boys("Naman", 16));
//        boysList.add(new Boys("Lakhan", 17));
//        boysList.add(new Boys("Arhan", 18));
//
//        List<Boys> newList = boysList.stream()
//                .filter(boy -> boy.getName().startsWith("A")).collect(Collectors.toList());
//
//        System.out.println(boysList.toString());
//        System.out.println("Newww");
//        System.out.println(newList.toString());

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

//abstract class Animal{
//    String name;
////     public Animal(String name){
////         this.name = name;
////         System.out.println("Animal abstract class : "+name);
////     }
//
//     abstract void makeSound();
//}
//
//class Dog extends Animal{
//    public Dog(String name){
////        super(name);
//        System.out.println("Dog class : "+name);
//    }
//    @Override
//    void makeSound(){
//        System.out.println("BHOU BHOU "+ name);
//    }
//}
//
//class Boys{
//    String name;
//    int age;
//
//    public Boys(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return name + " (" + age + ")";
//    }
//}
//
