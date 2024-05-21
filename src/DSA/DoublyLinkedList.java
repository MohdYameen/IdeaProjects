package DSA;

public class DoublyLinkedList {

    class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //addFirst and //addLast
    //removeFirst and removeLast

    public void addFirst(int data){
        Node temp = new Node(data);
        size++;
        if(head == null){
            head = tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("Linkedlist is empty");
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head = tail =null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print(){
        Node temp = head;
        System.out.print("NULL <-> ");
        while(temp != null){
            System.out.print(temp.data+ " <-> ");
            temp= temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(dll.size);
//        dll.removeFirst();
//        dll.print();
//        System.out.println(dll.size);
        dll.reverse();
        dll.print();

    }
}
