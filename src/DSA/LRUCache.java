package DSA;

import java.util.HashMap;

class LRUCache {

    static class Node{
        int key, val;
        Node prev, next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    private int capacity, size;
    private HashMap<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = cache.get(key);
        if(n == null) return -1;
        moveToHead(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null){
            node.val = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if(size > capacity){
                Node tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    public void addNode(Node n){
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }

    public void removeNode(Node n){
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(Node n){
        removeNode(n);
        addNode(n);
    }

    public Node popTail(){
        Node res = tail.prev;
        removeNode(res);
        return res;

    }

    public static void main(String[] args) {

    }
}
