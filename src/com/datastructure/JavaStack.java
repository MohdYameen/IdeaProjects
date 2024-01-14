package com.datastructure;

import java.util.Iterator;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        Stack<Integer> copyStack = new Stack<>();
        Iterator<Integer> itr = stack.iterator();

        while (itr.hasNext()){
            copyStack.push(itr.next());
        }
        stack.clear();

        stack.push(1234);

        Iterator <Integer> itr2 = copyStack.iterator();

        while(itr2.hasNext()){
            stack.push(itr2.next());
        }

        System.out.println(stack);



    }
}
