package com.yameen;

public class MyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node (int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
    Node head;

    void add(int data){
        Node toAdd = new Node(data);
        if(head == null){
            head = toAdd;
            head.prev = null;
            return;
        }
        Node temp = head;
        while (temp.next != null ){
            temp.prev = temp;
            temp = temp.next;

        }
        temp.next = toAdd;
    }
    void show(){
        Node temp = head;
        System.out.println("My linkedList :");
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();

    }
    void showhead(){
        System.out.println("Head : " + head.data);
    }
    void showlast(){
        Node temp = head;
        Node prev = temp;
        System.out.print("Last Element : ");
        while(temp != null ){
            prev = temp;
            temp = temp.next;

        } System.out.print(prev.data+ " ");
        System.out.println();
    }
    void search(int a){
        Node temp = head;
        int count = 0;
        while(temp != null){
            if(temp.data == a){
                System.out.println("Found at position : " +count );
                return;
            }
            temp = temp.next;
            count +=1;
        }
        if(temp == null){
            System.out.println("Element not found");
        }

    }

    void Reverse(){
        Node current = head;
        Node prev=null, next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String ... args){
        MyLinkedList mll = new MyLinkedList();
        mll.add(4);
       // mll.show();
        mll.add(5);
        mll.add(24);
        mll.add(6);
        mll.add(23);

        MyLinkedList ml2;
        ml2 = mll;
        ml2.add(45);
        mll.show();
        ml2.show();
        ml2.showhead();
        ml2.Reverse();
        ml2.show();
        ml2.showhead();
        ml2.showhead();
        ml2.search(246);




    }
}
