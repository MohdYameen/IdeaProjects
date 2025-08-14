package com.yameen;

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long sum = convertToLong(l1) + convertToLong(l2);
////        System.out.println(sum);
//        ListNode node = new ListNode(-1);
//        ListNode list = node;
//        while(sum>0){
//            int temp = (int)sum%10;
////            System.out.println("temp : "+temp);
////            System.out.println("list value : "+list.val);
//
//            list.next = new ListNode(temp);
//
//            sum = sum/10;
////            System.out.println("after sum "+ sum);
//            list = list.next;
////            System.out.println("after adding t list : "+list.val);
//        }
//
//        return node.next;
//        ListNode dummy = new ListNode();
//        ListNode res = dummy;
//        int total = 0, carry = 0;
//
//        while (l1 != null || l2 != null || carry != 0) {
//            total = carry;
//
//            if (l1 != null) {
//                total += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                total += l2.val;
//                l2 = l2.next;
//            }
//
//            int num = total % 10;
//            carry = total / 10;
//            dummy.next = new ListNode(num);
//            dummy = dummy.next;
//        }
//
//        return res.next;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            System.out.println("val1 : "+val1);
            int val2 = (l2 != null) ? l2.val : 0;
            System.out.println("val2 : "+val2);

            int sum = val1 + val2 + carry;
            System.out.println("sum : "+sum);
            carry = sum / 10;
            System.out.println("carry : "+carry);

            current.next = new ListNode(sum % 10);
            System.out.println("to add in list : "+sum%10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            System.out.println();
        }

        return dummy.next;

    }

    public static long convertToLong(ListNode node){
        int x = 0;
        long sum = 0;
//        System.out.println("entered convert method");
        while(node != null){
//            System.out.println("node value"+ node.val);
            sum += node.val * Math.pow(10,x);
//            System.out.println("sum at : "+x+ " is : "+tempSum);
            node=node.next;
            x++;
//            sum+=tempSum;
        }
//        System.out.println("sum : "+sum);
        return sum;
    }

    public static void printListNode(ListNode node){
        while(node != null){
            System.out.println(node.val);
            node= node.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ans = addTwoNumbers(l1, l2);
//        System.out.println(convertToLong(l1));
//        System.out.println(convertToLong(l2));
//        printListNode(l1);
//        printListNode(ans);

    }

}
