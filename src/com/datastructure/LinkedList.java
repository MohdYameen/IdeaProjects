package com.datastructure;

public class LinkedList<S> {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    static Node head;
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
        System.out.println();
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

    int search(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key) return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }

    int helper(Node head, int key){
        if(head == null) return -1;
        if(head.data == key) return 0;
        int index = helper(head.next, key);
        if(index == -1) return -1;
        return index+1;
    }
    int searchRecursion(int key){
        return helper(head, key);
    }

    //Floyd's Cycle Finding Algorithm
    static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        LinkedList ll = new LinkedList();
//        ll.add(5);
//        ll.add(4);
//        ll.add(6);
//        ll.add(7);
//        ll.show();
//
//        //ll.reverse();
//        //ll.show();
//        System.out.println(ll.searchRecursion(7));

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;
        System.out.println(isCycle());



    }



}
