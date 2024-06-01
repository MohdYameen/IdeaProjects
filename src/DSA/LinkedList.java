package DSA;

public class LinkedList {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        //create new Node.
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        // assign head to next of new node.
        newNode.next = head;
        // assign new node as head
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int data, int index){
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i =0;
        while(i<index-1){
            temp = temp.next;
            i++;
        }
        //i = index-1
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return 0;
        } else if(head.next == null){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

    public int removeLast(){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return 0;
        } else if(head.next == null){
            int val = head.data;
            head = tail = null;
            return val;
        }
        //second last node is size - 2
        Node prev = head;
        int secondLastPosition = sizeOfLinkedList()-2;
        for(int i=0;i<secondLastPosition;i++){
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;

        return tail.data;
    }

    public void removeNthFromLast(int indexFromLast){
        int index = sizeOfLinkedList() - indexFromLast;
        int i = 1;
        Node prev = head;
        while(i < index){
            prev= prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public int itrSearchInLinkedList(int key){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return -1;
        }
        Node temp = head;
        int pos = 0;
        while(temp != null){
            if(key == temp.data){
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        return -1;
    }

    public int recSearchHelper(Node head, int key){
        if(head == null) return -1;
        if(head.data == key) return 0;
        int index = recSearchHelper(head.next, key);
        if(index == -1) return -1;
        return index+1;

    }

    public int recSearch(int key){
        return recSearchHelper(head,key);
    }

    public void reverse(){
        Node current = tail = head;
        Node prev = null;
        Node next;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    //Slow-fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isLinkedListPalindrome(){
        if(head == null || head.next == null) return true;
        Node midNode = findMid(head);

        //reverse half of linked list
        Node prev = null;
        Node currect = midNode;
        Node next;
        while(currect != null){
            next = currect.next;
            currect.next=prev;
            prev = currect;
            currect = next;
        }
        Node right = prev; // right half head
        Node left = head;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right=right.next;
        }
        return true;
    }

    void printLinkedList(){
        if(head == null){
            System.out.println("Linkedlist is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public int sizeOfLinkedList(){
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    //Cycle in LinkedList
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycleExist = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycleExist = true;
                break;
            }
        }
        if(!cycleExist) return;

        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public Node merge(Node leftHead, Node rightHead){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(leftHead != null && rightHead != null){
            if(leftHead.data <= rightHead.data){
                temp.next=leftHead;
                leftHead=leftHead.next;
                temp = temp.next;
            }
            else{
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        while (leftHead != null){
            temp.next=leftHead;
            leftHead=leftHead.next;
            temp = temp.next;
        }
        while (rightHead != null){
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    public void zigZag(){
        //find Mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftHead = head;
        Node rightHead = prev;

        Node nextLeft, nextRight;

        // alternate merge
        while(leftHead != null && rightHead != null){
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead = nextRight;
        }


    }


    public static void main(String[] args) {

       LinkedList ll = new LinkedList();
//        ll.addFirst(2);
//        ll.addFirst(1);
//        ll.addLast(3);
//        ll.addLast(4);
//        ll.addLast(5);
//        System.out.println(ll.sizeOfLinkedList());
//        ll.addAtIndex(20, 3);
//        ll.printLinkedList();
//        System.out.println(ll.sizeOfLinkedList());
//
//        ll.reverse();
//        ll.printLinkedList();

//        System.out.println("Found at index : "+ ll.itrSearchInLinkedList(3));
//        System.out.println("Rec search "+ ll.recSearch(13));
//        ll.removeNthFromLast(2);
//        ll.printLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
//        ll.printLinkedList();
//        System.out.println(ll.isCycle());
//        System.out.println(ll.isLinkedListPalindrome());
//        head = new Node(1);
//        head.next = new Node(6);
//        head.next.next = new Node(5);
//        head.next.next.next = new Node(4);
        //head.next.next.next.next = head.next;
        //1-2-3-4-1
        //System.out.println(isCycle());

        //ll.printLinkedList();
//        System.out.println(ll.isCycle());
//
//        removeCycle();
        ll.printLinkedList();
//        System.out.println(isCycle());
//        ll.head = ll.mergeSort(head);
//        ll.mergeSort(head);
//        ll.printLinkedList();
        ll.zigZag();
        ll.printLinkedList();

    }
}
