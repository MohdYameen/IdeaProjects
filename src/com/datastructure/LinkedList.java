package com.datastructure;

public class LinkedList {
    class Node{
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
            return;
        }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = toAdd;
    }
    void show(){
        Node t = head;
        while(t != null){
            System.out.print(t.data + " ");
            t=t.next;
        }
    }


    void reverse(){
        Node current = head;
        Node prev = null, next;
        while(current != null){
            next=current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head=prev;



    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(5);
        ll.add(4);
        ll.show();

        ll.reverse();
        ll.show();
    }



}
